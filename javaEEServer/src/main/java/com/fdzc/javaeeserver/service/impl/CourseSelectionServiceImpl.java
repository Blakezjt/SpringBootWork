package com.fdzc.javaeeserver.service.impl;

import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.entity.course.CourseSelection;
import com.fdzc.javaeeserver.mapper.CourseSelectMapper;
import com.fdzc.javaeeserver.service.CourseSelectionService;
import com.fdzc.javaeeserver.validate.CourseSelection.CourseSelectCreateValidate;
import com.fdzc.javaeeserver.validate.CourseSelection.CourseSelectSearchValidate;
import com.fdzc.javaeeserver.validate.CourseSelection.CourseSelectUpdateValidate;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.vo.Course.CourseSelectDetailVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CourseSelectionServiceImpl implements CourseSelectionService {

    @Resource
    private CourseSelectMapper courseSelectMapper;

    @Override
    public T courseSelectionList(PageValidate pageValidate, CourseSelectSearchValidate searchValidate) {
        return null;
    }

    @Override
    public CourseSelectDetailVo courseSelectionDetail(Integer Id) {
        return null;
    }

    @Override
    public void courseSelectionEdit(CourseSelectUpdateValidate UpdateValidate) {

    }

    @Override
    public void courseSelectionAdd(CourseSelectCreateValidate createValidate) {
        CourseSelection courseSelection = new CourseSelection();
        courseSelection.setId(UUID.randomUUID().toString());
        courseSelection.setCourseId(createValidate.getCourseId());
        courseSelection.setStudentId(createValidate.getStudentId());
        courseSelection.setSelectionTime(LocalDateTime.now());
        courseSelection.setIsSelect(createValidate.getIsSelect());
        courseSelection.setBeginTime(createValidate.getBeginTime());
        courseSelection.setEndTime(createValidate.getEndTime());
        courseSelectMapper.insert(courseSelection);
    }

    @Override
    public void courseSelectionDelete(Integer Id) {

    }
}
