import axiosUtil from "@/utils/axiosUtil.js";
export const examList = (pageNum, pageSize,search) => {
    return axiosUtil.get('/exam/list', {
        params: {
            pageNo: pageNum,
            pageSize: pageSize,
            examId:search.examId,
            courseId:search.courseId,
            examTime:search.examTime,
            examLocation:search.examLocation,
            examHour:search.examHour,
        }
    })
}

export const examDetail = (id)=>{
    return axiosUtil.get('/exam/detail',{
        params:{
            id : id
        }
    });
}

export const examEdit = (examE)=>{
    return axiosUtil.post('/exam/edit',examE);
}

export const examAdd = (examA)=>{
    return axiosUtil.post('/exam/add',examA);
}
export const examDelete = (id)=>{
    return axiosUtil.delete('/exam/delete',{
        params:{
            id : id
        }
    });
}