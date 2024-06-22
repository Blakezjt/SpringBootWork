import axiosUtil from "@/utils/axiosUtil.js";
//所有分页
export const findAllLeaveApplicationByPages = (pageNum, pageSize) => {
    return axiosUtil.get('/leaveapplication/teacherlist', {
        params: {
            page: pageNum,
            size: pageSize
        }
    })
}
//添加
export const AddLeaveapplication = (leaveApplication)=>{
    return axiosUtil.post('/leaveapplication/add',leaveApplication);
}
//更新
export const UpdateLeaveapplication = (leaveApplication)=>{
    return axiosUtil.post('/leaveapplication/update',leaveApplication);
}
//删除
export const DeleteLeaveapplication = (applicationId)=>{
    return axiosUtil.delete('/leaveapplication/deletebyId',{
        params:{
            applicationId : applicationId
        }
    });
}
//查询分页
export const SearchLeaveapplication = (studentId,pageNum, pageSize)=>{
    return axiosUtil.get('/leaveapplication/studentlist', {
        params: {
            studentId:studentId,
            page: pageNum,
            size: pageSize
        }
    })
}

//查询分页
export const Search2Leaveapplication = (approvalStatus,pageNum, pageSize)=>{
    return axiosUtil.get('/leaveapplication/studentlist2', {
        params: {
            approvalStatus:approvalStatus,
            page: pageNum,
            size: pageSize
        }
    })
}