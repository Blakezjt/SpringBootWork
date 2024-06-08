package com.fdzc.javaeeserver.service;

import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.validate.teacher.TeacherCreateValidate;
import com.fdzc.javaeeserver.validate.teacher.TeacherSearchValidate;
import com.fdzc.javaeeserver.validate.teacher.TeacherUpdateValidate;
import com.fdzc.javaeeserver.vo.teacher.TeacherDetailVo;

public interface TeacherService {

    T teacherList(PageValidate pageValidate, TeacherSearchValidate teacherSearchValidate);

    TeacherDetailVo teacherDetail(Integer teacherId);

    void teacherEdit(TeacherUpdateValidate teacherUpdateValidate);

    void teacherAdd(TeacherCreateValidate createValidate);

    void teacherDelete(Integer teacherId);
}
