import { createRouter, createWebHashHistory } from "vue-router";
import Login from '../components/Login.vue'
import manMainIndex from '../components/ManMainIndex.vue'
import LeaveApplication from '../components/LeaveApplication/LeaveApplication.vue'
import IDCard from '../components/IDCard/IDCard.vue'
import Healthreport from '../components/healthreport/healthreport.vue'

import stuList from '../components/student/stuList.vue'
import workBench from '../components/workbench/index.vue'
import teaList from '../components/teacher/teaList.vue'
import courseSchedule from "../components/course/courseSchedule.vue";
import courseSelect from "../components/course/courseSelect.vue";
import exam from "../components/course/exam.vue";
import grades from "../components/course/grade.vue"

const route = createRouter({
    history: createWebHashHistory(),
    routes: [
        { path: '/', redirect: "/login" },
        { path: '/login', component: Login },
        {
            path: '/manMain',
            component: manMainIndex,
            children: [
                { path: 'workBench', component: workBench },
                { path: 'stuList', component: stuList },
                { path: 'LeaveApplication', component: LeaveApplication },
                { path: 'IDCard', component: IDCard },
                { path: 'teaList', component: teaList },
                { path: 'courseSchedule', component: courseSchedule },
                { path: 'courseSelect', component: courseSelect },
                { path: 'exam', component: exam },
                { path: 'grades', component: grades },
                { path: 'Healthreport', component: Healthreport },
            ]
        },
    ]
})

export default route