package com.fdzc.javaeeserver.service;

import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.validate.CourseSelection.CourseSelectCreateValidate;
import com.fdzc.javaeeserver.validate.CourseSelection.CourseSelectSearchValidate;
import com.fdzc.javaeeserver.validate.CourseSelection.CourseSelectUpdateValidate;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.vo.Course.CourseSelectDetailVo;

public interface CourseSelectionService {

    T courseSelectionList(PageValidate pageValidate, CourseSelectSearchValidate searchValidate);

    CourseSelectDetailVo courseSelectionDetail(Integer Id);

    void courseSelectionEdit(CourseSelectUpdateValidate UpdateValidate);

    void courseSelectionAdd(CourseSelectCreateValidate createValidate);

    void courseSelectionDelete(Integer Id);
}
