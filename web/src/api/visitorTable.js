import axiosUtil from "@/utils/axiosUtil.js";
export const findAllVisitorByPages = (pageNum, pageSize) => {
    return axiosUtil.get('/visitor/managerVisList', {
        params: {
            pageNum: pageNum,
            pageSize: pageSize
        }
    })
}

export const stuQueryVisitors = (pageNum, pageSize) => {
    return axiosUtil.get('/visitor/visitorList', {
        params: {
            pageNum: pageNum,
            pageSize: pageSize
        }
    })
}