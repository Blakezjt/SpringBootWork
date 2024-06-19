import axiosUtil from "@/utils/axiosUtil.js";

export const stuLoginService = (loginData)=>{
    //借助于URLSearchParams完成传递
    const params =  new URLSearchParams();
    for (const key in loginData) {
       params.append(key,loginData[key]);
    }
    return axiosUtil.post('/stu/login',params);
}

export const manLoginService = (loginData)=>{
    //借助于URLSearchParams完成传递
    const params =  new URLSearchParams();
    for (const key in loginData) {
       params.append(key,loginData[key]);
    }
    return axiosUtil.post('/manager/login',params);
}

export const pluLoginService = (loginData)=>{
    //借助于URLSearchParams完成传递
    const params =  new URLSearchParams();
    for (const key in loginData) {
       params.append(key,loginData[key]);
    }
    return axiosUtil.post('/plumber/login',params);
}