<template>
    <div class="demo-input-size">
      <div>水电工号：<el-input v-model="input1" class="inputStyle" placeholder="Please Input" /><el-button type="primary"
          :icon="Search" >Search</el-button></div>
      <div>是否维修：<el-input v-model="input2" class="inputStyle" placeholder="Please Input" /><el-button type="primary"
          :icon="Search" >Search</el-button></div>
    </div>
  
    <el-table :data="tableList" stripe style="width: 100%" @cell-click="cellClick">
      <el-table-column prop="plumberSno" label="水电工号" />
      <el-table-column prop="studentSno" label="学号" />
      <el-table-column prop="studentName" label="学生姓名" />
      <el-table-column prop="dorm" label="所在宿舍" />
      <el-table-column prop="repairsProduct" label="报修信息" />
      <el-table-column prop="isRepairs" label="是否维修" />
      <el-table-column prop="" label="操作">
      <el-button type="primary" :icon="Edit" circle @click="dialogFormVisible = true" />
      <el-button type="danger" :icon="Delete" circle @click="deleteDetail" />
    </el-table-column>
    </el-table>
    <div class="demo-pagination-block">
      <el-pagination v-model:current-page="currentPage4" v-model:page-size="pageSize4" :page-sizes="[2, 4]" :small="small"
        :disabled="disabled" :background="background" layout="total, sizes, prev, pager, next, jumper" :total="total"
        @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    </div>

    <el-dialog v-model="centerDialogVisible" title="Warning" width="30%" center>
    <span>
      您确定删除吗？
    </span>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="centerDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="logOut">
          确定
        </el-button>
      </span>
    </template>
  </el-dialog>
  </template>
    
  <script lang="js" setup>
  import { ref, reactive } from 'vue'
  import { stuQueryRes } from '../api/repairTable.js'
  import { useRoute } from 'vue-router';
  const route = useRoute();
  import {
  Delete,
  Edit,
  Search,
} from '@element-plus/icons-vue'
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
  const AllRepairByPages = () => {
    let result = stuQueryRes(currentPage4.value, pageSize4.value);
    // tableData.value = result; 
    result.then(function (data) {
      // 在这里可以访问后端数据  
      tableData.value = data.data;
    });
    setTimeout(() => {
      tableData.value.list.forEach(element => {
          if(element.isRepairs == '1'){
            element.isRepairs = '是'
          }else{
            element.isRepairs = '否'
          }
      });
      tableList.value = tableData.value.list;
      total.value = tableData.value.total;
      console.log(tableList.value);
    }, 500)
    
  }
  AllRepairByPages();
  const handleSizeChange = (val) => {
    console.log(`${val} items per page`)
    if (input1.value == '' && input2.value == '') {
      AllRepairByPages();
    }
    else {
      // snoQuery();
    }
  }
  const handleCurrentChange = (val) => {
    console.log(`current page: ${val}`)
    if (input1.value == '' && input2.value == '') {
      AllRepairByPages();
    }
    else {
      // snoQuery();
    }
  }
  // const snoQuery = () => {
  //   const query = queryStuByPages(currentPage4.value, pageSize4.value, input1.value, input2.value);
  //   query.then(function (data) {
  //     // 在这里可以访问后端数据  
  //     console.log(data.data); // 输出："John"  
  //     tableData.value = data.data;
  //   });
  //   setTimeout(() => {
  //     console.log(tableData.value.total);
  //     tableList.value = tableData.value.list;
  //     total.value = tableData.value.total;
  //   }, 500)
  // }
  const repairsId = ref(0)
  const cellClick = (row)=>{
    repairsId.value = row.id
  }
  const centerDialogVisible = ref(false)
  import {stuDeleteDetail} from '../api/deleteDetail.js'
  const deleteDetail = ()=>{
    centerDialogVisible.value = true
  }
  const logOut =()=>{
    centerDialogVisible.value = false
    stuDeleteDetail(repairsId.value)
    AllRepairByPages();
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