package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.entity.course.CourseSchedule;
import com.fdzc.javaeeserver.entity.course.CourseSelection;
import com.fdzc.javaeeserver.mapper.CourseSelectionMapper;
import com.fdzc.javaeeserver.service.CourseSelectionService;
import com.fdzc.javaeeserver.validate.CourseSelection.CourseSelectCreateValidate;
import com.fdzc.javaeeserver.validate.CourseSelection.CourseSelectSearchValidate;
import com.fdzc.javaeeserver.validate.CourseSelection.CourseSelectUpdateValidate;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.vo.Course.CourseSelectDetailVo;
import com.fdzc.javaeeserver.vo.Course.CourseSelectListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class CourseSelectionServiceImpl implements CourseSelectionService {

    @Resource
    private CourseSelectionMapper courseSelectionMapper;

    @Override
    public T courseSelectionList(PageValidate pageValidate, CourseSelectSearchValidate searchValidate) {
        Integer pageNo = pageValidate.getPageNo();
        Integer pageSize = pageValidate.getPageSize();

        QueryWrapper<CourseSelection> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("student_id");

        Page<CourseSelection> CoursePage = courseSelectionMapper.selectPage(new Page<>(pageNo, pageSize), queryWrapper);

        List<CourseSelectListVo> list = new LinkedList<>();
        for (CourseSelection course: CoursePage.getRecords()) {
            CourseSelectListVo vo = new CourseSelectListVo();
            BeanUtils.copyProperties(course,vo);
            list.add(vo);
        }


        return T.success(list, (int) CoursePage.getTotal());
    }

    @Override
    public CourseSelectDetailVo courseSelectionDetail(Integer Id) {
        CourseSelection course = courseSelectionMapper.selectOne(new QueryWrapper<CourseSelection>()
                .eq("student_id", Id)
                .last("limit 1"));
        CourseSelectDetailVo courseDetailVo = new CourseSelectDetailVo();
        BeanUtils.copyProperties(course,courseDetailVo);
        return courseDetailVo;
    }

    @Override
    public void courseSelectionEdit(CourseSelectUpdateValidate updateValidate) {
        CourseSelection courseSelection = courseSelectionMapper.selectOne(new QueryWrapper<CourseSelection>()
                .eq("student_id", updateValidate.getStudentId())
                .last("limit 1"));
        courseSelection.setIsSelect(updateValidate.getIsSelect());
        courseSelection.setEndTime(updateValidate.getEndTime());
        courseSelection.setBeginTime(updateValidate.getBeginTime());
        courseSelectionMapper.updateById(courseSelection);
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
        courseSelectionMapper.insert(courseSelection);
    }

    @Override
    public void courseSelectionDelete(Integer Id) {
        CourseSelection courseSelection = courseSelectionMapper.selectOne(new QueryWrapper<CourseSelection>()
                .eq("course_id", Id)
                .eq("student_id",1));
        courseSelectionMapper.deleteById(courseSelection);
    }
}
