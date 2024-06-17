import axiosUtil from "@/utils/axiosUtil.js";
export const ManUpdatePwd = (url,ruleForm) => {
    return axiosUtil.patch(url, ruleForm);
}