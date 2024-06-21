import { createRouter, createWebHashHistory } from "vue-router";
import Login from '../components/Login.vue'
import stuMainIndex from '../components/StuMainIndex.vue'
import manMainIndex from '../components/ManMainIndex.vue'
import stuDetailTable from '../components/stuDetailTable.vue'
import dormTable from '../components/dormTable.vue'
import managerUpdate from '../components/managerUpdate.vue'
import updatePwd from '../components/updatePwd.vue'
import repairTable from '../components/repairTable.vue'
import visitorTable from '../components/visitorTable.vue'
import outOrIn from '../components/outOrIn.vue'
import stuUpdate from '../components/stuUpdate.vue'
import submitRepairs from '../components/submitRepairs.vue'
import addVisitor from '../components/addVisitor.vue'
import addOutOrIn from '../components/addOutOrIn.vue'
import pluMainIndex from '../components/PluMainIndex.vue'
import waterAndEle from '../components/waterAndEle.vue'
import pluUpdate from '../components/PluUpdate.vue'
import stuRepairsTable from '../components/stuRepairsTable.vue'
import stuVisitor from '../components/stuVisitor.vue'
import stuOutOrIn from '../components/stuOutOrIn.vue'
import text from '../components/text.vue'

// import LeaveApplication from '../components/LeaveApplication/LeaveApplication.vue'
// import IDCard from '../components/IDCard/IDCard.vue'

import stuList from '../components/student/stuList.vue'
import workBench from '../components/workbench/index.vue'
const route = createRouter({
    history: createWebHashHistory(),
    routes: [
        { path: '/', redirect: "/login" },
        { path: '/login', component: Login },
        {
            path: '/manMain',
            component: manMainIndex,
            children: [
                { path: 'stuList', component: stuList },
                { path: 'stuDetailTable', component: stuDetailTable },
                { path: 'dormTable', component: dormTable },
                { path: 'managerUpdate', component: managerUpdate },
                { path: 'updatePwd', component: updatePwd },
                { path: 'repairTable', component: repairTable },
                { path: 'visitorTable', component: visitorTable },
                { path: 'outOrIn', component: outOrIn },
                // { path: 'LeaveApplication', component: LeaveApplication },
                // { path: 'IDCard', component: IDCard },
                { path: 'workBench', component: workBench },
            ]
        },
    ]
})

export default route