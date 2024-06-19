package com.fdzc.javaeeserver.service;

import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.validate.Exams.ExamsCreateValidate;
import com.fdzc.javaeeserver.validate.Exams.ExamsSearchValidate;
import com.fdzc.javaeeserver.validate.Exams.ExamsUpdateValidate;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.vo.Exams.ExamsDetailVo;


public interface ExamsService {


    T  examsList(PageValidate pageValidate, ExamsSearchValidate examsSearchValidate);

    ExamsDetailVo  examsDetail(Integer id);

    void  examsEdit(ExamsUpdateValidate UpdateValidate);

    void examsAdd(ExamsCreateValidate createValidate);

    void examsDelete(Integer id);
}
