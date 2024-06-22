import axiosUtil from "@/utils/axiosUtil.js";
export const gradesList = (pageNum, pageSize,search) => {
    return axiosUtil.get('/grades/list', {
        params: {
            pageNo: pageNum,
            pageSize: pageSize,
            studentId:search.studentId,
            courseId:search.courseId,
            grade:search.grade,
            gpa:search.gpa,
        }
    })
}

export const gradesDetail = (id)=>{
    return axiosUtil.get('/grades/detail',{
        params:{
            id : id
        }
    });
}

export const gradesEdit = (gradesE)=>{
    return axiosUtil.post('/grades/edit',gradesE);
}

export const gradesAdd = (gradesA)=>{
    return axiosUtil.post('/grades/add',gradesA);
}
export const gradesDelete = (id)=>{
    return axiosUtil.delete('/grades/delete',{
        params:{
            id : id
        }
    });
}