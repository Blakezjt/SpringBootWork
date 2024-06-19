import axiosUtil from "@/utils/axiosUtil.js";
export const ManUpdateDetail = (ruleForm) => {
    return axiosUtil.put('/manager/update', ruleForm);
}

export const stuUpdateDetail = (ruleForm) => {
    return axiosUtil.put('/stu/update', ruleForm);
}

export const pluUpdateDetail = (ruleForm) => {
    return axiosUtil.put('/plumber/update', ruleForm);
}
