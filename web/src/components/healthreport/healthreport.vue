<template>
    <div class="demo-input-size">
        <el-form :inline="true" :model="searchForm" class="demo-form-inline" ref="ruleFormRef" :rules="rules" status-icon>
            <el-form-item label="学号">
                <el-input v-model="searchForm.studentId" placeholder="Approved by" clearable />
            </el-form-item>
            <el-form-item label="打卡状态">
                <el-select v-model="searchForm.healthStatus" placeholder="打卡状态" style="width: 240px">
                    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value" />
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit(searchForm)">查询</el-button>
                <el-button @click="resetForm">重置</el-button>
            </el-form-item>
        </el-form>

    </div>

    <div class="mb-4" style="margin-bottom: 20px;">
        <el-button type="success" plain @click="showAddDialog">添加+</el-button>
    </div>

    <el-table :data="tableList" stripe style="width: 100%" @cell-click="cellClick">
        <el-table-column prop="studentId" label="学号" />
        <el-table-column prop="studentName" label="姓名" />
        <el-table-column prop="date" label="打卡日期" />
        <el-table-column prop="healthStatus" label="健康状态" />
        <el-table-column prop="" label="操作">
            <el-button type="primary" :icon="Edit" circle @click="showUpdateDialog" />
            <el-button type="danger" :icon="Delete" circle @click=" centerDialogVisible = true" />
        </el-table-column>
    </el-table>
    <div class="demo-pagination-block">
        <el-pagination v-model:current-page="currentPage4" v-model:page-size="pageSize4" :page-sizes="[2, 10]"
            :small="small" :disabled="disabled" :background="background" layout="total, sizes, prev, pager, next, jumper"
            :total="total" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    </div>

    <!-- 修改弹出form -->
    <el-dialog v-model="dialogFormVisible" :title="addFrame ? '添加' : '更新'" width="600px" draggable>
        <el-form :model="ruleForm" ref="ruleFormRef" :rules="rules" label-width="180px" class="demo-ruleForm"
            :size="formSize" status-icon>
            <el-form-item label="学号">
                <el-input v-model="ruleForm.studentId" placeholder="Please input" />
            </el-form-item>
            <el-form-item label="姓名">
                <el-input v-model="ruleForm.studentName" placeholder="Please input" />
            </el-form-item>
            <el-form-item label="打卡日期" v-if="addFrame == false">
                <el-input v-model="ruleForm.date" placeholder="Please input" />
            </el-form-item>
            <el-form-item label="健康状态">
                <el-radio-group v-model="ruleForm.healthStatus">
                    <el-radio-button label="健康" value="健康"/>
                    <el-radio-button label="不健康" value="不健康" />
                    <el-radio-button label="未打卡" value="未打卡" />
                </el-radio-group>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="handleSubmit(ruleFormRef)">
                    {{ addFrame ? '添加' : '更新' }}
                </el-button>
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
import { ref, reactive } from 'vue'

import { findAllHealthreportByPages,AddHealthreport,UpdateHealthreport,DeleteHealthreport,SearchHealthreport,SearchHealthreport2} from '../../api/healthreport/healthreport.js'
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
const pageSize4 = ref(2)
const small = ref(false)
const background = ref(true)
const disabled = ref(false)
//弹出的修改窗口
const dialogFormVisible = ref(false)
const dormId = ref(0)
//弹出删除确认框
const centerDialogVisible = ref(false)
//添加
const addFrame = ref(false);

//请假状态选择
const options = [
    {
        value: '健康',
        label: '健康',
    },
    {
        value: '不健康',
        label: '不健康',
    },
    {
        value: '未打卡',
        label: '未打卡',
    }
]

//初始化数据、分页
const list = () => {
    let result = findAllHealthreportByPages(currentPage4.value, pageSize4.value);
    // tableData.value = result; 
    result.then(function (data) {
        // 在这里可以访问后端数据  
        tableData.value = data.data;
        // console.log(tableData.value);
        tableList.value = tableData.value.records;
        total.value = tableData.value.total;
    });
}
list();

//查询函数
const searsh = (searchForm) => {
    let result;
    if (searchForm.studentId != '') {
        result = SearchHealthreport(searchForm.studentId, currentPage4.value, pageSize4.value);
    } else if (searchForm.healthStatus != "") {
        result = SearchHealthreport2(searchForm.healthStatus, currentPage4.value, pageSize4.value);
    }
    // tableData.value = result; 
    result.then(function (data) {
        // 在这里可以访问后端数据  
        tableData.value = data.data;
        // console.log(tableData.value);
        tableList.value = tableData.value.records;
        console.log(tableData.value.records);
        total.value = tableData.value.total;
    });
}
const showAddDialog = () => {
    resetRuleForm();
    addFrame.value = true;
    dialogFormVisible.value = true;
};

const showUpdateDialog = () => {
    addFrame.value = false;
    dialogFormVisible.value = true;
};

const handleSubmit = (ruleFormRef) => {
    if (addFrame.value) {
        // 添加证件逻辑
        add(ruleFormRef)
    } else {
        // 更新证件逻辑
        submitForm(ruleFormRef)
    }
};

//点添加，初始学生证件信息
const add11 = () => {
    resetRuleForm();
    dialogFormVisible.value = true;
    addFrame.value = true;
}

//添加学生证件记录
const add = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
        if (valid) {
            AddHealthreport(ruleForm).then(() => {
                list();
                dialogFormVisible.value = false;
                open1();
            });
        } else {
            console.log('error submit!', fields)
        }
    })
}

//删除请假记录
const deleteLie = () => {
    centerDialogVisible.value = false;
    console.log(ruleForm.reportId);
    DeleteHealthreport(ruleForm.reportId).then(() => {
        open1();
        list();
    });

}

const handleSizeChange = (val) => {
    // console.log(`${val} items per page`)
    if (searchForm.studentId == ''&& searchForm.healthStatus == "") {
        list()
    } else {
        searsh(searchForm)
    }
}
const handleCurrentChange = (val) => {
    if (searchForm.studentId == ''&& searchForm.healthStatus == "") {
        list()
    } else {
        searsh(searchForm)
    }

}

// 创建一个重置函数来还原 ruleForm 的状态
function resetRuleForm() {
    // 创建一个新的 RuleForm 对象，并分配给 ruleForm
    Object.assign(ruleForm, {
        reportId: '',
        studentId: '',
        studentName: '',
        date: '',
        healthStatus: ''
    });
}

//修改dorm的弹窗

//校验form
import type { FormInstance, FormRules } from 'element-plus'

interface RuleForm {
    reportId: any
    studentId: any
    studentName: string
    date: string
    healthStatus: string
}

interface SearchForm {
    studentId: any
    healthStatus:string
}

const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<RuleForm>({
    reportId: 0,
    studentId: '',
    studentName: '',
    date: '',
    healthStatus: ''
})
const searchForm = reactive<SearchForm>({
    studentId: '',
    healthStatus:''
})

const rules = reactive<FormRules<RuleForm>>({
    // studentSno: [
    //     { required: false, message: 'Please input studentSno', trigger: 'blur' },
    //     { min: 9, max: 9, message: 'Length should be 9', trigger: 'blur' },
    // ],
})
//查询
const onSubmit = (searchForm) => {
    // console.log(searchForm);
    searsh(searchForm);
    open1();
}
//重置
const resetForm = () => {
    Object.assign(searchForm, {
        studentId: '',
        studentName: '',
        healthStatus: ''
    });
    list();
    open1();
}

const submitForm = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
        if (valid) {
            console.log('submit!')
            UpdateHealthreport(ruleForm).then(() => {
                console.log(ruleForm);
                list();
                dialogFormVisible.value = false;
                open1();
            });
            dialogFormVisible.value = false;
        } else {
            console.log('error submit!', fields)
        }
    })
}
const cellClick = (row: any) => {
    ruleForm.reportId = row.reportId;
    ruleForm.studentId = row.studentId;
    ruleForm.studentName = row.studentName;
    ruleForm.date = row.date;
    ruleForm.healthStatus = row.healthStatus;

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