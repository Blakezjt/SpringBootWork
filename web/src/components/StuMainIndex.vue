<template>
  <div class="common-layout">
    <el-container>
      <el-aside width="200px">
        <div class="aside">
          <el-row class="tac">
            <el-col :span="30">
              <h5 class="mb-2">功能</h5>
              <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
                <el-sub-menu index="1">
                  <template #title>
                    <el-icon>
                      <location />
                    </el-icon>
                    <span>个人信息</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="1-1">
                      <RouterLink to="/stuMain/stuUpdate">更新个人信息</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-2">
                      <RouterLink to="/stuMain/updatePwd">
                        更改密码
                      </RouterLink>
                    </el-menu-item>
                  </el-menu-item-group>
                </el-sub-menu>
                <el-sub-menu index="2">
                  <template #title>
                    <el-icon>
                      <location />
                    </el-icon>
                    <span>添加信息(报修、登记等)</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="2-1">
                      <RouterLink to="/stuMain/submitRepairs">提交报修信息</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="2-2">
                      <RouterLink to="/stuMain/addVisitor">登记访客</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="2-3">
                      <RouterLink to="/stuMain/addOutOrIn">出入物品登记</RouterLink>
                    </el-menu-item>
                  </el-menu-item-group>
                </el-sub-menu>
                <el-sub-menu index="3">
                  <template #title>
                    <el-icon>
                      <location />
                    </el-icon>
                    <span>查询信息(报修、登记等)</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="2-1">
                      <RouterLink to="/stuMain/stuRepairsTable">报修信息</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="2-2">
                      <RouterLink to="/stuMain/stuVisitor">访客信息</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="2-3">
                      <RouterLink to="/stuMain/stuOutOrIn">出入物品信息</RouterLink>
                    </el-menu-item>
                  </el-menu-item-group>
                </el-sub-menu>
              </el-menu>
            </el-col>
          </el-row>
        </div>

      </el-aside>
      <el-container>
        <el-header style="display: flex; justify-content: space-between;">
          <h1>
            学生模块
          </h1>
          <el-dropdown class="dropdown">
            <span class="el-dropdown-link">
              {{ ManName }}
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
        <!-- <el-footer>Footer</el-footer> -->
      </el-container>
    </el-container>
  </div>

  <el-dialog v-model="centerDialogVisible" title="Warning" width="30%" center>
    <span>
      您确定退出登入吗？
    </span>
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
//获取管理员名字
import { queryStuDetail } from '../api/queryDetail.js'
const ManName = ref('')
const getManName = () => {
  const result = queryStuDetail();
  result.then((data) => {
    ManName.value = data.data.studentName
  })
}
onMounted(() => {
  getManName();
})
</script>
  
<style scoped>
.aside {
  height: 590px;
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