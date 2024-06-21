import axiosUtil from "@/utils/axiosUtil.js";
export const stuList = (pageNum, pageSize,stuSearch) => {
    return axiosUtil.get('/student/list', {
        params: {
            pageNo: pageNum,
            pageSize: pageSize,
            studentId:stuSearch.studentId,
            studentName:stuSearch.studentName,
            studentXb:stuSearch.studentXb,
            studentDept:stuSearch.studentDept
        }
    })
}

export const stuDetail = (id)=>{
    return axiosUtil.get('/student/detail',{
        params:{
            id : id
        }
    });
}

export const stuEdit = (stuE)=>{
    return axiosUtil.post('/student/edit',stuE);
}

export const stuAdd = (stuA)=>{
    return axiosUtil.post('/student/add',stuA);
}
export const stuDelete = (id)=>{
    return axiosUtil.delete('/student/delete',{
        params:{
            id : id
        }
    });
}