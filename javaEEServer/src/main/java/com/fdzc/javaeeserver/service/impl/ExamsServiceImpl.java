package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.entity.course.CourseSchedule;
import com.fdzc.javaeeserver.entity.course.Exams;
import com.fdzc.javaeeserver.mapper.ExamsMapper;
import com.fdzc.javaeeserver.service.ExamsService;
import com.fdzc.javaeeserver.validate.Exams.ExamsCreateValidate;
import com.fdzc.javaeeserver.validate.Exams.ExamsSearchValidate;
import com.fdzc.javaeeserver.validate.Exams.ExamsUpdateValidate;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.vo.Exams.ExamsDetailVo;
import com.fdzc.javaeeserver.vo.Exams.ExamsListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class ExamsServiceImpl implements ExamsService {
    @Resource
    private ExamsMapper examsMapper;
    @Override
    public T examsList(PageValidate pageValidate, ExamsSearchValidate examsSearchValidate) {
        Integer pageNo = pageValidate.getPageNo();
        Integer pageSize = pageValidate.getPageSize();

        QueryWrapper<Exams> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("exam_id");

        Page<Exams> examsPage = examsMapper.selectPage(new Page<>(pageNo, pageSize), queryWrapper);
        List<ExamsListVo> list = new LinkedList<>();
        for (Exams stu: examsPage.getRecords()) {
            ExamsListVo vo = new ExamsListVo();
            BeanUtils.copyProperties(stu,vo);
            list.add(vo);
        }


        return T.success(list, (int) examsPage.getTotal());
    }

    @Override
    public ExamsDetailVo examsDetail(Integer id) {
        Exams exams = examsMapper.selectOne(new QueryWrapper<Exams>()
                .eq("exam_id", id)
                .last("limit 1"));
        ExamsDetailVo DetailVo = new ExamsDetailVo();
        BeanUtils.copyProperties(exams,DetailVo);
        return DetailVo;
    }

    @Override
    public void examsEdit(ExamsUpdateValidate UpdateValidate) {
        Exams exams = examsMapper.selectOne(new QueryWrapper<Exams>()
                .eq("exam_id", UpdateValidate.getExamId())
                .last("limit 1"));
        exams.setExamHour(UpdateValidate.getExamHour());
        exams.setExamTime(UpdateValidate.getExamTime());
        exams.setExamLocation(UpdateValidate.getExamLocation());
        examsMapper.updateById(exams);
    }

    @Override
    public void examsAdd(ExamsCreateValidate createValidate) {
        Exams exams = new Exams();
        exams.setId(UUID.randomUUID().toString());
        QueryWrapper<Exams> QueryWrapper = new QueryWrapper<Exams>().orderByDesc("exam_id");
        Exams exams1 = examsMapper.selectOne(QueryWrapper.last("limit 1"));
        Integer examId = exams1.getExamId();
        exams.setExamId(examId + 1);
        exams.setCourseId(createValidate.getCourseId());
        exams.setExamTime(createValidate.getExamTime());
        exams.setExamLocation(createValidate.getExamLocation());
        exams.setExamHour(createValidate.getExamHour());
        examsMapper.insert(exams);
    }

    @Override
    public void examsDelete(Integer Id) {
        Exams examId = examsMapper.selectOne(new QueryWrapper<Exams>()
                .eq("exam_id", Id));
        examsMapper.deleteById(examId);
    }
}
