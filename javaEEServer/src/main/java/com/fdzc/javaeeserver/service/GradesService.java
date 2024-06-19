package com.fdzc.javaeeserver.service;

import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.validate.grades.GradesCreateValidate;
import com.fdzc.javaeeserver.validate.grades.GradesSearchValidate;
import com.fdzc.javaeeserver.validate.grades.GradesUpdateValidate;
import com.fdzc.javaeeserver.vo.Grades.GradesDetailVo;

public interface GradesService {

    T gradesList(PageValidate pageValidate, GradesSearchValidate SearchValidate);

    GradesDetailVo gradesDetail(String id);

    void gradesEdit(GradesUpdateValidate UpdateValidate);

    void gradesAdd(GradesCreateValidate createValidate);

    void gradesDelete(String id);
}
