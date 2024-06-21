<template>
    <div class="head">
        <el-calendar ref="calendar" class="calendar">
            <template #header="{ date }">
                <span>日历</span>
                <span>{{ date }}</span>
                <el-button-group>
                    <el-button size="small" @click="selectDate('prev-year')">
                        前年
                    </el-button>
                    <el-button size="small" @click="selectDate('prev-month')">
                        前月
                    </el-button>
                    <el-button size="small" @click="selectDate('today')">今天</el-button>
                    <el-button size="small" @click="selectDate('next-month')">
                        下月
                    </el-button>
                    <el-button size="small" @click="selectDate('next-year')">
                        下年
                    </el-button>
                </el-button-group>
            </template>
        </el-calendar>
        <div class="div1">
            <div style="width: 30%;">
                <el-card style="max-width: 300px">
                    <template #header>
                        <div class="card-header">
                            <span>学生</span>
                        </div>
                    </template>
                    <!-- <p v-for="o in 4" :key="o" class="text item">{{ 'List item ' + o }}</p> -->
                     <p class="text item">预计访问量：100</p>
                     <p class="text item">今日访问量：100</p>
                     <p class="text item">总人数量：100</p>
                     <p class="text item">总访问量：100</p>
                    <template #footer>Footer content</template>
                </el-card>
            </div>
            <div style="width: 30%;">
                <el-card style="max-width: 300px">
                    <template #header>
                        <div class="card-header">
                            <span>老师</span>
                        </div>
                    </template>
                    <p class="text item">预计访问量：100</p>
                     <p class="text item">今日访问量：100</p>
                     <p class="text item">总人数量：100</p>
                     <p class="text item">总访问量：100</p>
                    <template #footer>Footer content</template>
                </el-card>
            </div>
            <div style="width: 30%;">
                <el-card style="max-width: 300px">
                <template #header>
                    <div class="card-header">
                        <span>管理员</span>
                    </div>
                </template>
                <p class="text item">预计访问量：100</p>
                <p class="text item">今日访问量：100</p>
                <p class="text item">学生总数量：100</p>
                <p class="text item">总访问量：100</p>
                <template #footer>Footer content</template>
            </el-card>
            </div>
            
        </div>
    </div>

     <Gradient></Gradient>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import type { CalendarDateType, CalendarInstance } from 'element-plus'
import Gradient from '../echartComponents/gradient.vue'
const calendar = ref<CalendarInstance>()
const selectDate = (val: CalendarDateType) => {
    if (!calendar.value) return
    calendar.value.selectDate(val)
}


</script>

<style scoped>
.head {
    display: flex;
}

.el-calendar {
    width: 33.3%;
    /* 设置日历的宽度 */
    height: 300px;
    /* 设置日历的高度 */
    --el-calendar-cell-width: px;
}

.div1 {
    width: 70%;
    height: 330px;
    background-color: rgb(189, 231, 249);
    display: flex;
    justify-content: space-around;
}
</style>
