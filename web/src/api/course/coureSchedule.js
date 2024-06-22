import axiosUtil from "@/utils/axiosUtil.js";
export const courseScheduleList = (pageNum, pageSize,search) => {
    return axiosUtil.get('/courseSchedule/list', {
        params: {
            pageNo: pageNum,
            pageSize: pageSize,
            courseId:search.courseId,
            teacherId:search.teacherId,
            classroomId:search.classroomId,
            courseName:search.courseName,
            date:search.date,
            time:search.time,
        }
    })
}

export const courseScheduleDetail = (id)=>{
    return axiosUtil.get('/courseSchedule/detail',{
        params:{
            id : id
        }
    });
}

export const courseScheduleEdit = (courseScheduleE)=>{
    return axiosUtil.post('/courseSchedule/edit',courseScheduleE);
}

export const courseScheduleAdd = (courseScheduleA)=>{
    return axiosUtil.post('/courseSchedule/add',courseScheduleA);
}
export const courseScheduleDelete = (id)=>{
    return axiosUtil.delete('/courseSchedule/delete',{
        params:{
            id : id
        }
    });
}