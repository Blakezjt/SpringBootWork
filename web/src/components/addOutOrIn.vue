<template>
    <el-form
      ref="ruleFormRef"
      :model="ruleForm"
      :rules="rules"
      label-width="140px"
      class="demo-ruleForm"
      :size="formSize"
      status-icon
    >
      <el-form-item label="出入物品名称" prop="goods">
        <el-input v-model="ruleForm.goods" />
      </el-form-item>
      <el-form-item label="出入">
        <el-radio-group v-model="ruleForm.outOrIn" class="ml-4">
          <el-radio label="出" size="large">出</el-radio>
          <el-radio label="入" size="large">入</el-radio>
        </el-radio-group>
      </el-form-item> 
      <el-form-item>
        <el-button type="primary" @click="submitForm(ruleFormRef)">
          提交
        </el-button>
        <el-button @click="resetForm(ruleFormRef)">重置</el-button>
      </el-form-item>
    </el-form>
  </template>
  
  <script lang="ts" setup>
  import { reactive, ref } from 'vue'
  import type { FormInstance, FormRules } from 'element-plus'
  import { ElMessage } from 'element-plus'
  interface RuleForm {
    goods: string
    outOrIn: String
  }
  
  const formSize = ref('default')
  const ruleFormRef = ref<FormInstance>()
  const ruleForm = reactive<RuleForm>({
    goods: '',
    outOrIn:'出',
  })
  
  const rules = reactive<FormRules<RuleForm>>({
    goods: [
      { required: true, message: 'Please input Activity name', trigger: 'blur' },
    ],
  })
  import { outOrInAdd } from '../api/outOrIn.js'
  const submitForm = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
      if (valid) {
        outOrInAdd(ruleForm);
        ElMessage.success('提交成功')
        console.log('submit!')
      } else {
        console.log('error submit!', fields)
      }
    })
  }
  
  const resetForm = (formEl: FormInstance | undefined) => {
    if (!formEl) return
    formEl.resetFields()
  }
  
  </script>
  