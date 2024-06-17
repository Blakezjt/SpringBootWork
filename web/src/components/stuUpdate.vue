<template>
    <el-form ref="ruleFormRef" :model="ruleForm" :rules="rules" label-width="120px" class="demo-ruleForm" :size="formSize"
      status-icon>
      <el-form-item label="学号">
        <el-input v-model="ruleForm.studentSno" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model=" ruleForm.studentName" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="性别">
        <el-input v-model="ruleForm.sex" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="学期">
        <el-input v-model="ruleForm.academy" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="专业">
        <el-input v-model="ruleForm.major" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="年级">
        <el-input v-model="ruleForm.grade" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="班级">
        <el-input v-model="ruleForm.className" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="楼号">
        <el-input v-model="ruleForm.dormId" disabled placeholder="Please input" />
      </el-form-item>
      <el-form-item label="宿舍">
        <el-input v-model="ruleForm.buildingNo" disabled placeholder="Please input" />
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
  import { ElMessage } from 'element-plus'
  import type { FormInstance, FormRules } from 'element-plus'
  interface RuleForm {
    studentSno:string
    studentName:string
    academy:string
    major:string
    grade:string
    className:string
    dormId:string
    sex:string
    phone:string
    buildingNo:string
    email:string
  }
  
  const formSize = ref('default')
  const ruleFormRef = ref<FormInstance>()
  const ruleForm = reactive<RuleForm>({
    studentSno:'',
    studentName:'',
    academy:'',
    major:'',
    grade:'',
    className:'',
    dormId:'',
    sex:'',
    phone:'',
    buildingNo:'',
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
  import { stuUpdateDetail } from '../api/updateDetail.js'
  const submitForm = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
      if (valid) {
        console.log('submit!')
        ElMessage.success('信息更新成功')
        centerDialogVisible.value = false
        stuUpdateDetail(ruleForm)
      } else {
        console.log('error submit!', fields)
        ElMessage.success('信息更新失败')
      }
    })
  }
  const resetForm = (formEl: FormInstance | undefined) => {
    if (!formEl) return
    queryDetailTable();
  }
  
  //获取学生详情
  import { queryStuDetail } from '../api/queryDetail.js'
  const queryDetailTable = () => {
    const result = queryStuDetail();
    result.then((data:any)=>{
      ruleForm.studentSno = data.data.studentSno
      ruleForm.studentName = data.data.studentName
      ruleForm.sex = data.data.sex
      ruleForm.academy = data.data.academy
      ruleForm.major = data.data.major
      ruleForm.grade = data.data.grade
      ruleForm.className = data.data.className
      ruleForm.dormId = data.data.dormId
      ruleForm.buildingNo = data.data.buildingNo
      ruleForm.phone = data.data.phone
      ruleForm.email = data.data.email
    })
  }
  //选择楼号
  
  const buildingId = ref("")
  
  const handleChange = (value) => {
    ruleForm.buildingNo = value[0]
    console.log(ruleForm.buildingNo)
  }
  
  const options = [
    {
      value: '东一',
      label: '东一',
    },
    {
      value: '东二',
      label: '东二',
    },
    {
      value: '东三',
      label: '东三',
    },
  
  ]
  const centerDialogVisible = ref(false)
  
  onMounted(() => {
    queryDetailTable();
  })
  </script>
  