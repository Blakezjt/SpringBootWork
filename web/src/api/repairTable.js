import axiosUtil from "@/utils/axiosUtil.js";
export const findAllRepairByPages = (url,pageNum, pageSize) => {
    return axiosUtil.get(url, {
        params: {
            pageNum: pageNum,
            pageSize: pageSize
        }
    })
}

// export const queryStuByPages = (pageNum, pageSize,sno,dorm) => {
//     return axiosUtil.get('/stu/queryStuList', {
//         params: {
//             pageNum: pageNum,
//             pageSize: pageSize,
//             sno:sno,
//             dorm:dorm
//         }
//     })
// }
export const submitRep = (repairObj) => {
    return axiosUtil.get('/repairs/add', {
        params: {
            repairObj: repairObj,
        }
    })
}


export const stuQueryRes = (pageNum, pageSize) => {
    return axiosUtil.get('/repairs/repairsInfo', {
        params: {
            pageNum: pageNum,
            pageSize: pageSize
        }
    })
}
