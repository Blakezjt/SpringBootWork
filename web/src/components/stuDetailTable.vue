<template>
  <div class="demo-input-size">
    <div>学号：<el-input v-model="input1" class="inputStyle" placeholder="Please Input" /><el-button type="primary"
        :icon="Search" @click="snoQuery">Search</el-button></div>
    <div>宿舍号：<el-input v-model="input2" class="inputStyle" placeholder="Please Input" /><el-button type="primary"
        :icon="Search" @click="snoQuery">Search</el-button></div>
  </div>

  <el-table :data="tableList" stripe style="width: 100%">
    <el-table-column prop="studentId" label="学号" />
    <el-table-column prop="studentName" label="姓名" />
    <el-table-column prop="studentSex" label="性别" />
    <el-table-column prop="studentXb" label="系别" />
    <el-table-column prop="studentDept" label="专业" />
    <el-table-column prop="dormitoryId" label="宿舍号" />
    <el-table-column prop="studentPhone" label="电话" />
  </el-table>
  <div class="demo-pagination-block">
    <el-pagination v-model:current-page="currentPage4" v-model:page-size="pageSize4" :page-sizes="[2, 4]" :small="small"
      :disabled="disabled" :background="background" layout="total, sizes, prev, pager, next, jumper" :total="total"
      @size-change="handleSizeChange" @current-change="handleCurrentChange" />
  </div>
</template>
  
<script lang="js" setup>
import { ref, reactive } from 'vue'
import { Search } from '@element-plus/icons-vue'
import { findAllStuByPages, queryStuByPages } from '../api/stuTable.js'
//搜索框
const input1 = ref('')
const input2 = ref('')
//table
const tableData = ref({});
const tableList = ref([]);
const total = ref(0);
//分页
const currentPage4 = ref(1)
const pageSize4 = ref(2)
const small = ref(false)
const background = ref(true)
const disabled = ref(false)
const AllStuByPages = () => {
  let result = findAllStuByPages(currentPage4.value, pageSize4.value);
  // tableData.value = result; 
  result.then(function (data) {
    // 在这里可以访问后端数据  
    tableData.value = data.data;
  });
  setTimeout(() => {
    tableList.value = tableData.value.data.rows;
    console.log( tableData.value.data.rows);
    total.value = tableData.value.data.total;
    // console.log( total.value);
  }, 500)

}
AllStuByPages();
const handleSizeChange = (val) => {
  console.log(`${val} items per page`)
  if (input1.value == '' && input2.value == '') {
    AllStuByPages();
  }
  else {
    snoQuery();
  }
}
const handleCurrentChange = (val) => {
  console.log(`current page: ${val}`)
  if (input1.value == '' && input2.value == '') {
    AllStuByPages();
  }
  else {
    snoQuery();
  }
}
const snoQuery = () => {
  const query = queryStuByPages(currentPage4.value, pageSize4.value, input1.value, input2.value);
  query.then(function (data) {
    // 在这里可以访问后端数据  
    console.log(data.data); // 输出："John"  
    tableData.value = data.data;
  });
  setTimeout(() => {
    console.log(tableData.value.total);
    tableList.value = tableData.value.data.rows;
    total.value = tableData.value.data.total;
  }, 500)
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
</style>