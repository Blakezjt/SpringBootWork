<template>
  <div class="demo-input-size">
    <div>学号：<el-input v-model="input1" class="inputStyle" placeholder="Please Input" /><el-button type="primary"
        :icon="Search" @click="snoQuery">Search</el-button></div>
    <div>宿舍号：<el-input v-model="input2" class="inputStyle" placeholder="Please Input" /><el-button type="primary"
        :icon="Search" @click="snoQuery">Search</el-button></div>

  </div>

  <el-table :data="tableList" stripe style="width: 100%" @cell-click="cellClick">
    <el-table-column prop="id" label="ID" />
    <el-table-column prop="studentSno" label="学号" />
    <el-table-column prop="buildingNo" label="楼号" />
    <el-table-column prop="dormId" label="宿舍号" />
    <el-table-column prop="bedNum" label="床号" />
    <el-table-column prop="isEmpty" label="床号是否为空" />
    <el-table-column prop="" label="操作">
      <el-button type="primary" :icon="Edit" circle @click="dialogFormVisible = true" />
      <el-button type="danger" :icon="Delete" circle />
    </el-table-column>
  </el-table>
  <div class="demo-pagination-block">
    <el-pagination v-model:current-page="currentPage4" v-model:page-size="pageSize4" :page-sizes="[2, 4]" :small="small"
      :disabled="disabled" :background="background" layout="total, sizes, prev, pager, next, jumper" :total="total"
      @size-change="handleSizeChange" @current-change="handleCurrentChange" />
  </div>

  <!-- 修改弹出form -->
  <el-dialog v-model="dialogFormVisible" title="Shipping address">
    <el-form :model="ruleForm" ref="ruleFormRef" :rules="rules" label-width="120px" class="demo-ruleForm" :size="formSize"
      status-icon>
      <el-form-item label="ID">
        <el-input v-model="ruleForm.id" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="楼号">
        <el-input v-model="ruleForm.buildingNo" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="宿舍号">
        <el-input v-model="ruleForm.dormId" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="床号">
        <el-input v-model="ruleForm.bedNum" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="学号" prop="studentSno">
        <el-input v-model="ruleForm.studentSno" />
      </el-form-item>
      <el-form-item label="是否有人住">
        <el-radio-group v-model="ruleForm.isEmpty" class="ml-4">
          <el-radio label="是" size="large">是</el-radio>
          <el-radio label="否" size="large">否</el-radio>
        </el-radio-group>
      </el-form-item> 
      <el-form-item>
      <el-button type="primary" @click="submitForm(ruleFormRef)"
        >更新</el-button
      >
      <el-button @click="dialogFormVisible = false">取消</el-button>
    </el-form-item>
    </el-form>
    
  </el-dialog>
</template>
    
<script lang="ts" setup>
import {
  Delete,
  Edit,
  Search,
} from '@element-plus/icons-vue'
import { ref, reactive } from 'vue'
import { findAllDormByPages, queryDormByPages, findAllDormIsEmptyByPages, ManUpdateDormDetail} from '../api/dormTable.js'
//搜索框
const input1 = ref('')
const input2 = ref('')
//table
interface tableDataInter {
  total: any,
  list: any,
}
const tableData = ref<tableDataInter>({
  total: 0,
  list: []
});
const tableList = ref([]);
const total = ref(0);
//分页
const currentPage4 = ref(1)
const pageSize4 = ref(2)
const small = ref(false)
const background = ref(true)
const disabled = ref(false)
//弹出的修改窗口
const dialogFormVisible = ref(false)
const dormId = ref(0)

//初始化数据
const AllDormByPages = () => {
  let result = findAllDormByPages(currentPage4.value, pageSize4.value);
  // tableData.value = result; 
  result.then(function (data) {
    // 在这里可以访问后端数据  
    tableData.value = data.data;
  });
  setTimeout(() => {
    tableData.value.list.forEach(element => {
          if(element.isEmpty == '1'){
            element.isEmpty = '是'
          }else{
            element.isEmpty = '否'
          }
      });
    tableList.value = tableData.value.list;
    total.value = tableData.value.total;
  }, 500)
}
AllDormByPages();
const handleSizeChange = (val) => {
  console.log(`${val} items per page`)
  if (input1.value == '' && input2.value == '') {
    AllDormByPages();
  }
  else {
    snoQuery();
  }
}
const handleCurrentChange = (val) => {
  console.log(`current page: ${val}`)
  if (input1.value == '' && input2.value == '') {
    AllDormByPages();
  }
  else {
    snoQuery();
  }
}
const snoQuery = () => {
  const query = queryDormByPages(currentPage4.value, pageSize4.value, input1.value, input2.value);
  query.then(function (data) {
    // 在这里可以访问后端数据  
    tableData.value = data.data;
  });
  setTimeout(() => {
    tableList.value = tableData.value.list;
    total.value = tableData.value.total;
  }, 500)
}
//查询空的宿舍
const QueryEmpty = () => {
  const query = findAllDormIsEmptyByPages(currentPage4.value, pageSize4.value);
  query.then(function (data) {
    // 在这里可以访问后端数据  
    tableData.value = data.data;
  });
  setTimeout(() => {
    tableList.value = tableData.value.list;
    total.value = tableData.value.total;
  }, 500)
}
//修改dorm的弹窗

//校验form
import type { FormInstance, FormRules } from 'element-plus'

interface RuleForm {
  id: any
  buildingNo: string
  dormId: string
  bedNum: string
  isEmpty: string
  studentSno: string
}

const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<RuleForm>({
  id: 0,
  buildingNo: '',
  dormId: '',
  bedNum: '',
  isEmpty: '0',
  studentSno: ''
})

const rules = reactive<FormRules<RuleForm>>({
  studentSno: [
    { required: false, message: 'Please input studentSno', trigger: 'blur' },
    { min: 9, max: 9, message: 'Length should be 9', trigger: 'blur' },
  ],
})

const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      console.log('submit!')
      if (ruleForm.isEmpty == '是') {
        ruleForm.isEmpty = '1';
      }else{
        ruleForm.isEmpty = '0';
      }
      ManUpdateDormDetail(ruleForm);
      dialogFormVisible.value = false;
    } else {
      console.log('error submit!', fields)
    }
  })
}
const cellClick = (row: any) => {
  ruleForm.id = row.id;
  ruleForm.buildingNo = row.buildingNo;
  ruleForm.dormId = row.dormId;
  ruleForm.bedNum = row.bedNum;
  ruleForm.isEmpty = row.isEmpty;
  ruleForm.studentSno = row.studentSno;
  console.log(11);
  
}


</script>
  
<style scoped>
.demo-input-size {
  display: flex;
}

.inputStyle {
  width: 200px;
  margin-right: 5px;
}

.demo-input-size div {
  margin-left: 10px;
}

.demo-pagination-block {
  margin-top: 10px;
  float: right;
}

.el-button--text {
  margin-right: 15px;
}

.el-select {
  width: 300px;
}

.el-input {
  width: 300px;
}

.dialog-footer button:first-child {
  margin-right: 10px;
}
</style>