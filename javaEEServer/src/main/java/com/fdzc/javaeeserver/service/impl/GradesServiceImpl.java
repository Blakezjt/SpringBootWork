package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.entity.course.Exams;
import com.fdzc.javaeeserver.entity.course.Grades;
import com.fdzc.javaeeserver.mapper.GradesMapper;
import com.fdzc.javaeeserver.service.GradesService;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.validate.grades.GradesCreateValidate;
import com.fdzc.javaeeserver.validate.grades.GradesSearchValidate;
import com.fdzc.javaeeserver.validate.grades.GradesUpdateValidate;
import com.fdzc.javaeeserver.vo.Grades.GradesDetailVo;
import com.fdzc.javaeeserver.vo.Grades.GradesListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class GradesServiceImpl implements GradesService {
    @Resource
    private GradesMapper gradesMapper;

    @Override
    public T gradesList(PageValidate pageValidate, GradesSearchValidate SearchValidate) {
        Integer pageNo = pageValidate.getPageNo();
        Integer pageSize = pageValidate.getPageSize();

        QueryWrapper<Grades> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("student_id");

        Page<Grades> examsPage = gradesMapper.selectPage(new Page<>(pageNo, pageSize), queryWrapper);
        List<GradesListVo> list = new LinkedList<>();
        for (Grades grades: examsPage.getRecords()) {
            GradesListVo vo = new GradesListVo();
            BeanUtils.copyProperties(grades,vo);
            list.add(vo);
        }


        return T.success(list, (int) examsPage.getTotal());
    }

    @Override
    public GradesDetailVo gradesDetail(String id) {
        Grades grades = gradesMapper.selectOne(new QueryWrapper<Grades>()
                .eq("id", id)
                .last("limit 1"));
        GradesDetailVo DetailVo = new GradesDetailVo();
        BeanUtils.copyProperties(grades,DetailVo);
        return DetailVo;
    }

    @Override
    public void gradesEdit(GradesUpdateValidate updateValidate) {
        Grades grades = gradesMapper.selectOne(new QueryWrapper<Grades>()
                .eq("id", updateValidate.getId())
                .last("limit 1"));
        grades.setGrade(updateValidate.getCourseId());
        grades.setGpa(updateValidate.getGpa());
        grades.setRecordTime(LocalDateTime.now());
        gradesMapper.updateById(grades);
    }

    @Override
    public void gradesAdd(GradesCreateValidate createValidate) {
        Grades grades = new Grades();
        grades.setId(UUID.randomUUID().toString());
        //#
        grades.setStudentId(createValidate.getStudentId());
        grades.setCourseId(createValidate.getCourseId());
        grades.setGrade(createValidate.getGrade());
        grades.setGpa(createValidate.getGpa());
        grades.setRecordTime(LocalDateTime.now());
        gradesMapper.insert(grades);
    }

    @Override
    public void gradesDelete(String id) {
        Grades grades = gradesMapper.selectOne(new QueryWrapper<Grades>()
                .eq("id", id));
        gradesMapper.deleteById(grades);
    }
}
