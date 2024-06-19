import axiosUtil from "@/utils/axiosUtil.js";
export const findAllWaterAndEleByPages = (pageNum, pageSize) => {
    return axiosUtil.get('/waterAndEle/waterAndEleList', {
        params: {
            pageNum: pageNum,
            pageSize: pageSize
        }
    })
}