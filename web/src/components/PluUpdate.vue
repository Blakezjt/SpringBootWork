<template>
    <el-form ref="ruleFormRef" :model="ruleForm" :rules="rules" label-width="120px" class="demo-ruleForm" :size="formSize"
      status-icon>
      <el-form-item label="编号">
        <el-input v-model="ruleForm.plumberSno" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model=" ruleForm.plumberName" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="性别">
        <el-input v-model="ruleForm.sex" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="电话" prop="phone">
        <el-input v-model="ruleForm.phone" />
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="ruleForm.email" />
      </el-form-item>
  
      <el-form-item>
        <el-button type="primary" @click="centerDialogVisible = true">
          更新
        </el-button>
        <el-button @click="resetForm(ruleFormRef)">重置</el-button>
      </el-form-item>
    
    <el-dialog v-model="centerDialogVisible" title="确认框" width="30%" center>
      <span>
                  确定保存更新的信息吗？
      </span>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="centerDialogVisible = false">取消</el-button>
          <el-button type="primary" @click="submitForm(ruleFormRef)">
            确定
          </el-button>
        </span>
      </template>
    </el-dialog>
    </el-form>
  </template>
  
  <script lang="ts" setup>
  import { reactive, ref,onMounted } from 'vue'
  import type { FormInstance, FormRules } from 'element-plus'
  import { ElMessage } from 'element-plus'
  interface RuleForm {
    plumberSno:string
    plumberName:string
    sex:string
    phone:string
    email:string
  }
  
  const formSize = ref('default')
  const ruleFormRef = ref<FormInstance>()
  const ruleForm = reactive<RuleForm>({
    plumberSno:'',
    plumberName:'',
    sex:'',
    phone:'',
    email:'',
  })
  
  const rules = reactive<FormRules<RuleForm>>({
    phone: [
      { required: true, message: 'Please input phone', trigger: 'blur' },
      { min: 11, max: 11, message: 'Length should be 11', trigger: 'blur' },
    ],
    email: [
      { required: true, message: 'Please input Activity name', trigger: 'blur' },
    ],
  })
  //更新管理员信息
  import { pluUpdateDetail } from '../api/updateDetail.js'
  const submitForm = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
      if (valid) {
        console.log('submit!')
        centerDialogVisible.value = false
        ElMessage.success('更新成功')
        pluUpdateDetail(ruleForm)
      } else {
        console.log('error submit!', fields)
      }
    })
  }
  const resetForm = (formEl: FormInstance | undefined) => {
    if (!formEl) return
    queryDetailTable();
  }
  
  //获取管理员详情
  import { queryPluDetail } from '../api/queryDetail.js'
  const queryDetailTable = () => {
    const result = queryPluDetail();
    result.then((data:any)=>{
      ruleForm.plumberName = data.data.plumberSno
      ruleForm.plumberName = data.data.plumberName
      ruleForm.sex = data.data.sex
      ruleForm.phone = data.data.phone
      ruleForm.email = data.data.email
    })
  }
  
  const centerDialogVisible = ref(false)
  
  onMounted(() => {
    queryDetailTable();
  })
  </script>
  