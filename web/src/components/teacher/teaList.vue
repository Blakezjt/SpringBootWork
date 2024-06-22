<template>
    <div class="demo-input-size">
        <el-form :inline="true" :model="searchForm" class="demo-form-inline" ref="ruleFormRef" :rules="rules"
            status-icon>
            <el-form-item label="职工号">
                <el-input v-model="searchForm.teacherId" placeholder="Approved by" clearable />
            </el-form-item>
            <el-form-item label="姓名">
                <el-input v-model="searchForm.name" placeholder="Approved by" clearable />
            </el-form-item>
            <el-form-item label="学位">
                <el-input v-model="searchForm.degree" placeholder="Approved by" clearable />
            </el-form-item>
            <el-form-item label="专业">
                <el-input v-model="searchForm.major" placeholder="Approved by" clearable />
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">查询</el-button>
                <el-button @click="resetForm">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
    <div class="mb-4" style="margin-bottom: 20px;">
        <el-button type="success" plain @click="add">添加+</el-button>
    </div>
    <el-table :data="tableList" stripe style="width: 100%" @cell-click="cellClick" v-loading="loading"
        element-loading-text="Loading..." :element-loading-spinner="svg"
        element-loading-svg-view-box="-10, -10, 50, 50">
        <el-table-column prop="teacherId" label="职工号" sortable />
        <el-table-column prop="name" label="姓名" />
        <el-table-column prop="sex" label="性别" :formatter="formatSex" />
        <el-table-column prop="degree" label="学位" />
        <el-table-column prop="major" label="专业" />
        <el-table-column prop="email" label="邮箱" />
        <el-table-column prop="phone" label="电话" />
        <el-table-column prop="address" label="地址" />
        <el-table-column prop="salary" label="薪水" />
        <el-table-column prop="birthDate" label="生日" />
        <el-table-column prop="" label="操作">
            <el-button type="primary" :icon="Edit" circle @click="dialogFormVisible = true" />
            <el-button type="danger" :icon="Delete" circle @click=" centerDialogVisible = true;" />
        </el-table-column>
    </el-table>
    <div class="demo-pagination-block">
        <el-pagination v-model:current-page="currentPage4" v-model:page-size="pageSize4" :page-sizes="[20, 30]"
            :small="small" :disabled="disabled" :background="background"
            layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
            @current-change="handleCurrentChange" />
    </div>

    <!-- 修改弹出form -->
    <el-dialog v-model="dialogFormVisible" title="修改" width="500px">
        <el-form :model="ruleForm" ref="ruleFormRef" :rules="rules" label-width="120px" class="demo-ruleForm"
            :size="formSize" status-icon>
            <el-form-item label="学号">
                <el-input v-model="ruleForm.teacherId" disabled placeholder="Please input" />
            </el-form-item>
            <el-form-item label="密码" v-if="addFrame">
                <el-input v-model="ruleForm.password" placeholder="Please input" />
            </el-form-item>
            <el-form-item label="姓名">
                <el-input v-model="ruleForm.name" placeholder="Please input" />
            </el-form-item>
            <el-form-item label="性别">
                <el-radio-group v-model="ruleForm.sex" class="ml-4">
                    <el-radio label="1" size="large" :value="1" checked>男</el-radio>
                    <el-radio label="0" size="large" :value="0">女</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="学位">
                <el-input v-model="ruleForm.degree" placeholder="Please input" />
            </el-form-item>
            <el-form-item label="专业" prop="">
                <el-input v-model="ruleForm.major" />
            </el-form-item>
            <el-form-item label="邮箱">
                <el-input v-model="ruleForm.email" placeholder="Please input" />
            </el-form-item>
            <el-form-item label="电话">
                <el-input v-model="ruleForm.phone" placeholder="Please input" />
            </el-form-item>
            <el-form-item label="地址">
                <el-input v-model="ruleForm.address" placeholder="Please input" />
            </el-form-item>
            <el-form-item label="入职时间">
                <el-input v-model="ruleForm.hireDate" placeholder="Please input" />
            </el-form-item>
            <el-form-item v-if="addFrame">
                <el-button type="primary" @click="addStu(ruleFormRef)">添加</el-button>
                <el-button @click="dialogFormVisible = false">取消</el-button>
            </el-form-item>
            <el-form-item v-else>
                <el-button type="primary" @click="submitForm(ruleFormRef)">更新</el-button>
                <el-button @click="dialogFormVisible = false">取消</el-button>
            </el-form-item>
        </el-form>

    </el-dialog>
    <!--删除确认框 -->
    <el-dialog v-model="centerDialogVisible" title="确认框" width="30%" center>
        <span style="font-size: 20px;">
            确定删除该条信息吗？
        </span>
        <template #footer>
            <span class="dialog-footer">
                <el-button type="primary" @click="deleteLie">
                    确定
                </el-button>
                <el-button @click=" centerDialogVisible = false;">取消</el-button>
            </span>
        </template>
    </el-dialog>
</template>

<script lang="ts" setup>
import {
    Delete,
    Edit,
    Search,
} from '@element-plus/icons-vue'
import { ref, reactive, onMounted } from 'vue'
import { teacherList, teacherDetail, teacherEdit, teacherAdd, teacherDelete } from '../../api/teacher/teacher.js'
import { ElNotification } from 'element-plus'
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
const pageSize4 = ref(20)
const small = ref(false)
const background = ref(true)
const disabled = ref(false)
//弹出的修改窗口
const dialogFormVisible = ref(false)
//弹出确认框
const centerDialogVisible = ref(false)
//加载
const loading = ref(true)
const svg = `
          <path class="path" d="
            M 30 15
            L 28 17
            M 25.61 25.61
            A 15 15, 0, 0, 1, 15 30
            A 15 15, 0, 1, 1, 27.99 7.5
            L 15 15
          " style="stroke-width: 4px; fill: rgba(0, 0, 0, 0)"/>
        `
//添加
const addFrame = ref(false);
//查询
const onSubmit = () => {
    list(searchForm);
    open1();
}
//重置
const resetForm = () => {
    Object.assign(searchForm, {
        teacherId: '',
        name: '',
        degree: '',
        major: ''
    });
    list(searchForm);
    open1();
}
//初始化数据
const list = (searsh) => {
    let result = teacherList(currentPage4.value, pageSize4.value, searsh);
    result.then(function (data) {
        // 在这里可以访问后端数据  
        tableData.value = data.data;
        tableList.value = tableData.value.data.rows;
        total.value = tableData.value.data.total;
        loading.value = false;
    });
}
const formatSex = (row, column, cellValue, index) => {
    return cellValue === 1 ? '男' : '女';
};
onMounted(() => {
    list(searchForm);
})
//分页
const handleSizeChange = (val) => {
    console.log(`${val} items per page`)
    list(searchForm);
}
const handleCurrentChange = (val) => {
    console.log(`current page: ${val}`)
    list(searchForm);
}
//修改dorm的弹窗

//校验form
import type { FormInstance, FormRules } from 'element-plus'

interface RuleForm {
    teacherId: number
    name: string
    password: string
    sex: number
    birthDate: string
    email: string
    phone: string
    address: string
    hireDate: string
    salary: number
    degree: string
    major: string
}
const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<RuleForm>({
    teacherId: 0,
    name: '',
    password: '',
    sex: 0,
    birthDate: '',
    email: '',
    phone: '',
    address: '',
    hireDate: '',
    salary: 0,
    degree: '',
    major: '',
})
interface SearchForm {
    teacherId: string
    name: string
    degree: string
    major: string
}
const searchForm = reactive<SearchForm>({
    teacherId: '',
    name: '',
    degree: '',
    major: ''
})
// 创建一个重置函数来还原 ruleForm 的状态
function resetRuleForm() {
    // 创建一个新的 RuleForm 对象，并分配给 ruleForm
    Object.assign(ruleForm, {
        teacherId: 0,
        name: '',
        password: '',
        sex: 0,
        birthDate: '',
        email: '',
        phone: '',
        address: '',
        hireDate: '',
        salary: 0,
        degree: '',
        major: '',
    });
}
const rules = reactive<FormRules<RuleForm>>({
    // studentSno: [
    //   { required: false, message: 'Please input studentSno', trigger: 'blur' },
    //   { min: 9, max: 9, message: 'Length should be 9', trigger: 'blur' },
    // ],
})

const submitForm = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
        if (valid) {
            teacherEdit(ruleForm).then(() => {
                list(searchForm);
                dialogFormVisible.value = false;
                open1();
            });
        } else {
            console.log('error submit!', fields)
        }
    })
}

const cellClick = (row: any) => {
    ruleForm.teacherId = row.teacherId;
    ruleForm.name = row.name;
    ruleForm.sex = row.sex;
    ruleForm.birthDate = row.birthDate;
    ruleForm.email = row.email;
    ruleForm.phone = row.phone;
    ruleForm.address = row.address;
    ruleForm.hireDate = row.hireDate;
    ruleForm.salary = row.salary;
    ruleForm.degree = row.degree;
    ruleForm.major = row.major;
}

//点添加，初始学生信息
const add = () => {
    resetRuleForm();
    dialogFormVisible.value = true;
    addFrame.value = true;
}
//添加学生
const addStu = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
        if (valid) {
            teacherAdd(ruleForm).then(() => {
                list(searchForm);
                dialogFormVisible.value = false;
                open1();
            });
        } else {
            console.log('error submit!', fields)
        }
    })
}

//删除
const deleteLie = () => {
    centerDialogVisible.value = false;
    console.log(ruleForm.teacherId);
    teacherDelete(ruleForm.teacherId).then(() => {
        open1();
        list(searchForm);
    });

}
//提醒框
const open1 = () => {
    ElNotification({
        title: '操作成功',
        type: 'success',
    })
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