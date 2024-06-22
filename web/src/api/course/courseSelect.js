import axiosUtil from "@/utils/axiosUtil.js";
export const courseSelectList = (pageNum, pageSize,search) => {
    return axiosUtil.get('/courseSelect/list', {
        params: {
            pageNo: pageNum,
            pageSize: pageSize,
            studentId:search.studentId,
            courseId:search.courseId,
            isSelect:search.isSelect,
        }
    })
}

export const courseSelectDetail = (id)=>{
    return axiosUtil.get('/courseSelect/detail',{
        params:{
            id : id
        }
    });
}

export const courseSelectEdit = (courseSelectE)=>{
    return axiosUtil.post('/courseSelect/edit',courseSelectE);
}

export const courseSelectAdd = (courseSelectA)=>{
    return axiosUtil.post('/courseSelect/add',courseSelectA);
}
export const courseSelectDelete = (id)=>{
    return axiosUtil.delete('/courseSelect/delete',{
        params:{
            id : id
        }
    });
}