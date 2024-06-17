<template>
  <el-form ref="ruleFormRef" :model="ruleForm" :rules="rules" label-width="120px" class="demo-ruleForm" :size="formSize"
    status-icon>
    <el-form-item label="编号">
      <el-input v-model="ruleForm.managerSno" disabled placeholder="Please input" />
    </el-form-item>
    <el-form-item label="姓名">
      <el-input v-model=" ruleForm.managerName" disabled placeholder="Please input" />
    </el-form-item>
    <el-form-item label="性别">
      <el-input v-model="ruleForm.sex" disabled placeholder="Please input" />
    </el-form-item>
    <el-form-item label="楼号" prop="buildingNo">
      <el-cascader v-model="buildingId" :options="options" @change="handleChange" />
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

interface RuleForm {
  managerSno:string
  managerName:string
  sex:string
  phone:string
  buildingNo:string
  email:string
}

const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<RuleForm>({
  managerSno:'',
  managerName:'',
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
import { ManUpdateDetail } from '../api/updateDetail.js'
const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      console.log('submit!')
      centerDialogVisible.value = false
      ManUpdateDetail(ruleForm)
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
import { queryManDetail } from '../api/queryDetail.js'
const queryDetailTable = () => {
  const result = queryManDetail();
  result.then((data:any)=>{
    ruleForm.managerSno = data.data.managerSno
    ruleForm.managerName = data.data.managerName
    ruleForm.sex = data.data.sex
    ruleForm.phone = data.data.phone
    ruleForm.buildingNo = data.data.buildingNo
    ruleForm.email = data.data.email
    buildingId.value = ruleForm.buildingNo
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
