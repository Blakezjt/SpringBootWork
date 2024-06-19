import axiosUtil from "@/utils/axiosUtil.js";
export const findAllStuByPages = (pageNum, pageSize) => {
    return axiosUtil.get('/student/list', {
        params: {
            pageNo: pageNum,
            pageSize: pageSize
        }
    })
}

export const queryStuByPages = (pageNum, pageSize,sno,dorm) => {
    return axiosUtil.get('/stu/queryStuList', {
        params: {
            pageNum: pageNum,
            pageSize: pageSize,
            sno:sno,
            dorm:dorm
        }
    })
}