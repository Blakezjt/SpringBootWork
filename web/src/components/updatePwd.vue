<template>
  <el-form ref="ruleFormRef" :model="ruleForm" status-icon :rules="rules" label-width="120px" class="demo-ruleForm">
    <el-form-item label="旧密码" prop="old_pwd">
      <el-input v-model="ruleForm.old_pwd" type="password" autocomplete="off"/>
    </el-form-item>
    <el-form-item label="新密码" prop="new_pwd">
      <el-input v-model="ruleForm.new_pwd" type="password" autocomplete="off" />
    </el-form-item>
    <el-form-item label="重新输入密码" prop="re_pwd">
      <el-input v-model="ruleForm.re_pwd" type="password" autocomplete="off" />
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm(ruleFormRef)">Submit</el-button>
      <el-button @click="resetForm(ruleFormRef)">Reset</el-button>
    </el-form-item>
  </el-form>
</template>

<script lang="ts" setup>
import { reactive, ref ,onMounted} from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { ElMessage } from 'element-plus'
const ruleFormRef = ref<FormInstance>()

const validatePass = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('Please input the password'))
  } else {
    if (ruleForm.re_pwd !== '') {
      if (!ruleFormRef.value) return
      ruleFormRef.value.validateField('checkPass', () => null)
    }
    callback()
  }
}
const validatePass2 = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('Please input the password again'))
  } else if (value !== ruleForm.new_pwd) {
    callback(new Error("Two inputs don't match!"))
  } else {
    callback()
  }
}

const ruleForm = reactive({
  old_pwd: '',
  new_pwd: '',
  re_pwd: '',
})

const rules = reactive<FormRules<typeof ruleForm>>({
  old_pwd: [
    { required: true, message: 'Please input Activity name', trigger: 'blur' },
  ],
  new_pwd: [
    { required: true, message: 'Please input Activity name', trigger: 'blur' },
    { validator: validatePass, trigger: 'blur' }
  ],
  re_pwd: [
    { required: true, message: 'Please input Activity name', trigger: 'blur' },
    { validator: validatePass2, trigger: 'blur' }
  ],
})
import { ManUpdatePwd } from '../api/updatePwd.js'
import { useRouter,useRoute } from 'vue-router'
import { useTokenStore } from '../stores/token.js'
const Router = useRouter();
const Route = useRoute();
const tokenStore = useTokenStore();
const link = ref('')
const logOut = () => {
  Router.push('/login');
  tokenStore.removeToken();
}
const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate((valid) => {
    if (valid) {
      console.log('submit!')
      console.log(Route.fullPath);
      if(Route.fullPath == '/manMain/updatePwd'){
        link.value = '/manager/updatePwd';
      }else if(Route.fullPath == '/stuMain/updatePwd'){
        link.value = '/stu/updatePwd'
      }else{
        link.value = '/plumber/updatePwd'
      }
      console.log(ruleForm);
      
      const result = ManUpdatePwd(link.value,ruleForm);
      result.then((data) => {
        console.log(data.data);
        if (data.data == '更新密码成功') {
          ElMessage.success("更新密码成功")
          logOut();
        }
        else {
          ElMessage.error("原密码填写不正确")
        }
      })
      console.log(result);


    } else {
      console.log('error submit!')
      return false
    }
  })
}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}
</script>
