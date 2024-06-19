import axiosUtil from "@/utils/axiosUtil.js";
export const stuDeleteDetail = (id) => {
    return axiosUtil.delete("/repairs/delete/"+id);
}

