import axiosUtil from "@/utils/axiosUtil.js";
export const findAllOutOrInByPages = (pageNum, pageSize) => {
    return axiosUtil.get('/outOrIn/managerOutOrIn', {
        params: {
            pageNum: pageNum,
            pageSize: pageSize
        }
    })
}

export const outOrInAdd = (ruleForm) => {
    return axiosUtil.post('/outOrIn/add', ruleForm)
}

export const stuQueryOutOrIn = (pageNum, pageSize) => {
    return axiosUtil.get('/outOrIn/stuOutOrIn', {
        params: {
            pageNum: pageNum,
            pageSize: pageSize
        }
    })
}