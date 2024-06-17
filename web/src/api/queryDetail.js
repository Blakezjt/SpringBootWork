import axiosUtil from "@/utils/axiosUtil.js";
export const queryManDetail = () =>{
    return axiosUtil.get('/manager/ManagerInfo');
}
export const queryStuDetail = ()=>{
    return axiosUtil.get('/stu/stuInfo');
}

export const queryPluDetail = ()=>{
    return axiosUtil.get('/plumber/pluInfo');
}