import axiosUtil from "@/utils/axiosUtil.js";
export const teacherList = (pageNum, pageSize,teacherSearch) => {
    return axiosUtil.get('/teacher/list', {
        params: {
            pageNo: pageNum,
            pageSize: pageSize,
            teacherId:teacherSearch.teacherId,
            name:teacherSearch.name,
            degree:teacherSearch.degree,
            major:teacherSearch.major
        }
    })
}

export const teacherDetail = (id)=>{
    return axiosUtil.get('/teacher/detail',{
        params:{
            id : id
        }
    });
}

export const teacherEdit = (teacherE)=>{
    return axiosUtil.post('/teacher/edit',teacherE);
}

export const teacherAdd = (teacherA)=>{
    return axiosUtil.post('/teacher/add',teacherA);
}
export const teacherDelete = (id)=>{
    return axiosUtil.delete('/teacher/delete',{
        params:{
            id : id
        }
    });
}