<template>
  <div class="common-layout">
    <el-header class="home_header">
      <div class="home_title">校园一键通系统</div>
      <div class="home_userinfoContainer">
        <el-dropdown>
          <span class="el-dropdown-link home_userinfo">
            <el-icon class="el-icon--right">
              <arrow-down />
            </el-icon>
          </span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item @click="centerDialogVisible = true">退出登入</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </div>
    </el-header>

    <el-container>
      <el-aside width="200px">
        <div class="aside">
          <el-row class="tac">
            <el-col :span="30">
              <!-- <h5 class="mb-2" style="font-size: 20px;">功能</h5> -->
              <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
                <RouterLink to="/manMain/workBench">
                  <el-menu-item index="1" style="font-size: 18px;">
                    <el-icon>
                      <setting />
                    </el-icon>
                    工作台
                  </el-menu-item>
                </RouterLink>
                <el-sub-menu index="2">
                  <template #title>
                    <el-icon>
                      <location />
                    </el-icon>
                    <span style="font-size: 18px;">学生信息</span>
                  </template>
                  <el-menu-item-group>
                    <RouterLink to="/manMain/stuList">
                      <el-menu-item index="2-1">
                        学生列表
                      </el-menu-item>
                    </RouterLink>
                    <RouterLink to="/manMain/managerUpdate">
                      <el-menu-item index="2-2">
                        学生请假
                      </el-menu-item>
                    </RouterLink>
                    <RouterLink to="/manMain/updatePwd">
                      <el-menu-item index="2-3">
                        学生报修
                      </el-menu-item>
                    </RouterLink>
                    <RouterLink to="/manMain/updatePwd">
                      <el-menu-item index="2-4">
                        证件办理
                      </el-menu-item>
                    </RouterLink>
                  </el-menu-item-group>
                </el-sub-menu>
                <el-sub-menu index="3">
                  <template #title>
                    <el-icon>
                      <location />
                    </el-icon>
                    <span style="font-size: 18px;">老师信息</span>
                  </template>
                  <el-menu-item-group>
                    <RouterLink to="/manMain/stuList">
                      <el-menu-item index="3-1">
                        老师列表
                      </el-menu-item>
                    </RouterLink>
                  </el-menu-item-group>
                </el-sub-menu>
                <el-sub-menu index="4">
                  <template #title>
                    <el-icon>
                      <location />
                    </el-icon>
                    <span style="font-size: 18px;">课程信息</span>
                  </template>
                  <el-menu-item-group>
                    <RouterLink to="/manMain/stuList">
                      <el-menu-item index="4-1">
                        课程列表
                      </el-menu-item>
                    </RouterLink>
                    <RouterLink to="/manMain/managerUpdate">
                      <el-menu-item index="4-2">
                        选课系统
                      </el-menu-item>
                    </RouterLink>
                    <RouterLink to="/manMain/updatePwd">
                      <el-menu-item index="4-3">
                        成绩查询
                      </el-menu-item>
                    </RouterLink>
                    <RouterLink to="/manMain/updatePwd">
                      <el-menu-item index="4-4">
                        考试安排
                      </el-menu-item>
                    </RouterLink>
                  </el-menu-item-group>
                </el-sub-menu>
                <el-sub-menu index="5">
                  <template #title>
                    <el-icon>
                      <location />
                    </el-icon>
                    <span style="font-size: 18px;">行政服务</span>
                  </template>
                  <el-menu-item-group>
                    <RouterLink to="/manMain/stuList">
                      <el-menu-item index="5-1">
                        宿舍管理
                      </el-menu-item>
                    </RouterLink>
                  </el-menu-item-group>
                </el-sub-menu>
                <el-sub-menu index="6">
                  <template #title>
                    <el-icon>
                      <location />
                    </el-icon>
                    <span style="font-size: 18px;">财务和后勤服务</span>
                  </template>
                  <el-menu-item-group>
                    <RouterLink to="/manMain/stuList">
                      <el-menu-item index="6-1">
                        缴费系统
                      </el-menu-item>
                    </RouterLink>
                    <RouterLink to="/manMain/managerUpdate">
                      <el-menu-item index="6-2">
                        财务查询
                      </el-menu-item>
                    </RouterLink>
                    <RouterLink to="/manMain/updatePwd">
                      <el-menu-item index="6-3">
                        后勤服务
                      </el-menu-item>
                    </RouterLink>
                  </el-menu-item-group>
                </el-sub-menu>

                <el-sub-menu index="7">
                  <template #title>
                    <el-icon>
                      <location />
                    </el-icon>
                    <span style="font-size: 18px;">图书馆服务</span>
                  </template>
                  <el-menu-item-group>
                    <RouterLink to="/manMain/stuList">
                      <el-menu-item index="7-1">
                        图书检索
                      </el-menu-item>
                    </RouterLink>
                    <RouterLink to="/manMain/managerUpdate">
                      <el-menu-item index="7-2">
                        借阅管理
                      </el-menu-item>
                    </RouterLink>
                    <RouterLink to="/manMain/updatePwd">
                      <el-menu-item index="7-3">
                        电子资源
                      </el-menu-item>
                    </RouterLink>
                  </el-menu-item-group>
                </el-sub-menu>

                <el-sub-menu index="8">
                  <template #title>
                    <el-icon>
                      <location />
                    </el-icon>
                    <span style="font-size: 18px;">校园活动</span>
                  </template>
                  <el-menu-item-group>
                    <RouterLink to="/manMain/stuList">
                      <el-menu-item index="8-1">
                        社团管理
                      </el-menu-item>
                    </RouterLink>
                  </el-menu-item-group>
                </el-sub-menu>

                <el-sub-menu index="9">
                  <template #title>
                    <el-icon>
                      <location />
                    </el-icon>
                    <span style="font-size: 18px;">健康与安全服务</span>
                  </template>
                  <el-menu-item-group>
                    <RouterLink to="/manMain/stuList">
                      <el-menu-item index="9-1">
                        健康打卡
                      </el-menu-item>
                    </RouterLink>
                    <RouterLink to="/manMain/managerUpdate">
                      <el-menu-item index="9-2">
                        紧急联系人
                      </el-menu-item>
                    </RouterLink>
                    <RouterLink to="/manMain/updatePwd">
                      <el-menu-item index="9-3">
                        医疗预约
                      </el-menu-item>
                    </RouterLink>
                  </el-menu-item-group>
                </el-sub-menu>
                <el-sub-menu index="10">
                  <template #title>
                    <el-icon>
                      <location />
                    </el-icon>
                    <span style="font-size: 18px;">个人信息</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="10-1">
                      <RouterLink to="/manMain/managerUpdate">更新个人信息</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="10-2">
                      <RouterLink to="/manMain/updatePwd">
                        更改密码
                      </RouterLink>
                    </el-menu-item>
                  </el-menu-item-group>
                </el-sub-menu>
              </el-menu>
            </el-col>
          </el-row>
        </div>

      </el-aside>
      <el-main>
        <RouterView></RouterView>
      </el-main>
      <!-- <el-container>
        <el-header style="display: flex; justify-content: space-between;">
          <h1>
            管理员模块
          </h1>
          <el-dropdown class="dropdown">
            <span class="el-dropdown-link">
              {{ManName}}
              <el-icon class="el-icon--right">
                <arrow-down />
              </el-icon>
            </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item @click="centerDialogVisible = true">退出登入</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </el-header>
        <el-main>
          <RouterView></RouterView>
        </el-main>
        <el-footer>Footer</el-footer>
      </el-container> -->
    </el-container>
  </div>

  <el-dialog v-model="centerDialogVisible" title="您确定退出登入吗？" width="30%" center>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="centerDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="logOut">
          确定
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>



<script lang="ts" setup>
import { ref, onMounted } from 'vue'
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
  ArrowDown
} from '@element-plus/icons-vue'
import { useRouter } from 'vue-router'
import { useTokenStore } from '../stores/token.js'
const Router = useRouter();
const tokenStore = useTokenStore();
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const centerDialogVisible = ref(false)
const logOut = () => {
  centerDialogVisible.value = false
  Router.push('/login');
  tokenStore.removeToken();
}
// //获取管理员名字
// import { queryManDetail } from '../api/queryDetail.js'
// const ManName = ref('')
// const getManName = ()=>{
//   const result = queryManDetail();
//   result.then((data)=>{
//     ManName.value = data.data.managerName
//   })
// }
// onMounted(() => {
//   getManName();
// })
</script>

<style scoped>
a {
  text-decoration: none;
}

.home_container {
  height: 100%;
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
}

.home_header {
  background-color: #2b2b2b;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.home_title {
  color: #C2C2C2;
  font-size: 22px;
  display: inline;
}

.home_userinfo {
  color: #fff;
  cursor: pointer;
}

.home_userinfoContainer {
  display: inline;
  margin-right: 20px;
}

.aside {
  height: 900px;
  width: inherit;
  text-align: center;
}

.example-showcase .el-dropdown-link {
  cursor: pointer;
  color: var(--el-color-primary);
  display: flex;
  align-items: center;
}

.dropdown {
  margin-right: 50px;
  height: 50%;
  margin-top: 20px;
}
</style>