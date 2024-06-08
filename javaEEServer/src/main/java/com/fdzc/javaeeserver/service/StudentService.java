package com.fdzc.javaeeserver.service;


import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.validate.student.StudentCreateValidate;
import com.fdzc.javaeeserver.validate.student.StudentUpdateValidate;
import com.fdzc.javaeeserver.vo.student.StudentDetailVo;
import com.fdzc.javaeeserver.validate.student.StudentSearchValidate;

public interface StudentService {

    T studentList(PageValidate pageValidate, StudentSearchValidate studentSearchValidate);

    StudentDetailVo studentDetail(Integer studentId);

    void studentEdit(StudentUpdateValidate studentUpdateValidate);

    void studentAdd(StudentCreateValidate createValidate);

    void studentDelete(Integer studentId);
}
