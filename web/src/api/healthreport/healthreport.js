import axiosUtil from "@/utils/axiosUtil.js";
//查询所有记录
export const findAllHealthreportByPages = (pageNum, pageSize) => {
    return axiosUtil.get('/healthreport/teacherlist', {
        params: {
            page: pageNum,
            size: pageSize
        }
    })
}

//添加
export const AddHealthreport = (healthreport)=>{
    return axiosUtil.post('/healthreport/add',healthreport);
}
//更新
export const UpdateHealthreport = (healthreport)=>{
    return axiosUtil.post('/healthreport/update',healthreport);
}
//删除
export const DeleteHealthreport = (reportId)=>{
    return axiosUtil.delete('/healthreport/deletebyId',{
        params:{
            reportId : reportId
        }
    });
}
//查询分页
export const SearchHealthreport = (studentId,pageNum, pageSize)=>{
    return axiosUtil.get('/healthreport/studentlist', {
        params: {
            studentId:studentId,
            page: pageNum,
            size: pageSize
        }
    })
}

//查询分页
export const SearchHealthreport2 = (healthStatus,pageNum, pageSize)=>{
    return axiosUtil.get('/healthreport/studentlist2', {
        params: {
            healthStatus:healthStatus,
            page: pageNum,
            size: pageSize
        }
    })
}
