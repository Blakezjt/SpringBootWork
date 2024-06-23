import axiosUtil from "@/utils/axiosUtil.js";
//查询所有记录
export const findAllIDCardByPages = (pageNum, pageSize) => {
    return axiosUtil.get('/idcard/teacherlist', {
        params: {
            page: pageNum,
            size: pageSize
        }
    })
}

//添加
export const AddIDCard = (idcard)=>{
    return axiosUtil.post('/idcard/add',idcard);
}
//更新
export const UpdateIDCard = (idcard)=>{
    return axiosUtil.post('/idcard/update',idcard);
}
//删除
export const DeleteIDCard = (idcard)=>{
    return axiosUtil.delete('/idcard/deletebyId',{
        params:{
            idcard : idcard
        }
    });
}
//查询分页
export const SearchIDCard = (studentId,pageNum, pageSize)=>{
    return axiosUtil.get('/idcard/studentlist', {
        params: {
            studentId:studentId,
            page: pageNum,
            size: pageSize
        }
    })
}
