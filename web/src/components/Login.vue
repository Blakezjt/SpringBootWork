<!-- <template>
    <div>
        <el-container>
            <el-aside width="600px" style="background-color: aqua;">
                <div class="leftImg">
                    <h1>欢迎登入学生宿舍系统</h1>
                    <img src="../icon/1.png" alt="">
                </div>
            </el-aside>
            <el-main>
                <div class="inline-flex" h="30" w="30" m="2" :style="{
                    boxShadow: `var(--el-box-shadow-dark)`,
                }">
                    <el-form ref="ruleFormRef" :model="ruleForm" :rules="rules" label-width="70px" class="demo-ruleForm"
                        :size="formSize" status-icon>
                        <div v-if="radio == 3">
                            <el-form-item label="学号" prop="sno">
                                <el-input v-model="ruleForm.sno" />
                            </el-form-item>
                            <el-form-item label="密码" prop="password">
                                <el-input v-model="ruleForm.password" type="password" />
                            </el-form-item>
                        </div>
                        <div v-if="radio == 6">
                            <el-form-item label="编号" prop="sno">
                                <el-input v-model="ruleForm.sno" />
                            </el-form-item>
                            <el-form-item label="密码" prop="password">
                                <el-input v-model="ruleForm.password" type="password" />
                            </el-form-item>
                        </div>
                        <div v-if="radio == 9">
                            <el-form-item label="工号" prop="sno">
                                <el-input v-model="ruleForm.sno" />
                            </el-form-item>
                            <el-form-item label="密码" prop="password">
                                <el-input v-model="ruleForm.password" type="password" />
                            </el-form-item>
                        </div>
                        <el-radio-group v-model="radio">
                            <el-radio :label="3" @click="cleanData">学生</el-radio>
                            <el-radio :label="6" @click="cleanData">管理员</el-radio>
                            <el-radio :label="9" @click="cleanData">水电工</el-radio>
                        </el-radio-group>
                        <el-form-item>
                            <el-button type="primary" @click="submitForm(ruleFormRef)">
                                登入
                            </el-button>
                            <el-button @click="resetForm(ruleFormRef)">清空</el-button>
                        </el-form-item>
                    </el-form>

                </div>
            </el-main>
        </el-container>
    </div>
</template> -->
<template>
    <div class="background">
      <div class="login-container">
        <el-form ref="ruleFormRef" :model="ruleForm" label-width="80px" :rules="rules" hide-required-aterisk="true">
          <h3 class="title">系统登录</h3>
          <el-form-item label="账号：" prop="sno">
            <el-input v-model="ruleForm.sno" placeholder="请输入用户名" prop="sno"></el-input>
          </el-form-item>
          <el-form-item label="密码：" prop="password">
            <el-input v-model="ruleForm.password" placeholder="请输入密码" prop="password" type="password"></el-input>
          </el-form-item>
          
          <el-form-item>
            <el-button type="primary" @click="submitForm(ruleFormRef)" class="btn" :loading="logining">登录</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </template>
  
  
<script lang="ts" setup>
import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { stuLoginService, manLoginService, pluLoginService } from '../api/login.js'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
import { useTokenStore } from '../stores/token.js'
const tokenStore = useTokenStore();
const router = useRouter();
const radio = ref(3)
interface RuleForm {
    sno: string,
    password: string
}

const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<RuleForm>({
    sno: '',
    password: ''
})
const logining=false

const rules = reactive<FormRules<RuleForm>>({
    sno: [
        { required: true, message: '请输入账户', trigger: 'blur' },
        { min: 9, max: 9, message: '账户为9位', trigger: 'blur' },
    ],
    password: [
        { required: true, message: '请输入密码', trigger: 'blur' },
    ],
})

const submitForm = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
        if (valid) {
             manLogin();
        } else {
            console.log('error submit!', fields)
        }
    })
}

const resetForm = (formEl: FormInstance | undefined) => {
    if (!formEl) return
    formEl.resetFields()
}
//学生登入
const stuLogin = async () => {
    let result = await stuLoginService(ruleForm);
    ElMessage.success(result.msg ? result.msg : '登入成功');
    //把得到的token存储到pinia中
    tokenStore.setToken(result.data);
    
    router.push('/stuMain/stuUpdate');
}
//管理员登入
const manLogin = async () => {
    // let result = await manLoginService(ruleForm);
    // ElMessage.success(result.msg ? result.msg : '登入成功');
    ElMessage.success('登入成功');
    // tokenStore.setToken(result.data);
    router.push('/manMain/workbench');
}
//水电工登入
const pluLogin = async () => {
    let result = await pluLoginService(ruleForm);
    tokenStore.setToken(result.data);
    ElMessage.success(result.msg ? result.msg : '登入成功');
    router.push('/pluMain/pluUpdate');
}
//清空点击radio的数据
const cleanData = () => {
    ruleForm.sno = '',
        ruleForm.password = ''
}
</script>



<style scoped>
.background {
  position: fixed;
  height: 100%;
  width: 100%;
  top: 0;
  left: 0;
  background-image: url('../icon/backgroundimage.jpg');
  background-repeat: no-repeat; /* 不重复 */
  background-size: cover; /* 覆盖整个元素 */
  background-position: center; /* 居中 */
  animation: myanimation 10s infinite;
}

.title{
    margin-left: 40%;
}
.login-container {
  width: 400px;
  padding-top: 10px;
  padding-right: 20px;
  position: absolute;
  top: 30%;
  left: 38%;
  background-color: rgba(254, 254, 254, 0.921);
  border-radius: 15px;
}
.btn{
  margin-top: 20px;
  margin-right: 40px;
  width: 200px;
  margin-left: 30px;
}
</style>