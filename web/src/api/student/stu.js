import axiosUtil from "@/utils/axiosUtil.js";
export const stuList = (pageNum, pageSize) => {
    return axiosUtil.get('/student/list', {
        params: {
            pageNo: pageNum,
            pageSize: pageSize
        }
    })
}


export const queryDormByPages = (pageNum, pageSize,sno,dorm) => {
    return axiosUtil.get('/dorm/dormQueryList', {
        params: {
            pageNum: pageNum,
            pageSize: pageSize,
            sno:sno,
            dorm:dorm
        }
    })
}

export const findAllDormIsEmptyByPages = (pageNum, pageSize) => {
    return axiosUtil.get('/dorm/dormIsEmpty', {
        params: {
            pageNum: pageNum,
            pageSize: pageSize
        }
    })
}
//管理员更新宿舍
export const ManUpdateDormDetail = (ruleForm) => {
    return axiosUtil.put('/dorm/manDormUpdate', ruleForm);
}