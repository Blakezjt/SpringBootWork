import axiosUtil from "@/utils/axiosUtil.js";
export const findAllIDCardByPages = (pageNum, pageSize) => {
    return axiosUtil.get('/idcard/teacherlist', {
        params: {
            page: pageNum,
            size: pageSize
        }
    })
}