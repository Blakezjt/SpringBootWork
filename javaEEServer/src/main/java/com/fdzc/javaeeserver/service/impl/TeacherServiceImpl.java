package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.entity.Teachers;
import com.fdzc.javaeeserver.mapper.TeacherMapper;
import com.fdzc.javaeeserver.service.TeacherService;
import com.fdzc.javaeeserver.utils.Md5Utils;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.validate.teacher.TeacherCreateValidate;
import com.fdzc.javaeeserver.validate.teacher.TeacherSearchValidate;
import com.fdzc.javaeeserver.validate.teacher.TeacherUpdateValidate;
import com.fdzc.javaeeserver.vo.teacher.TeacherDetailVo;
import com.fdzc.javaeeserver.vo.teacher.TeacherListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public T teacherList(PageValidate pageValidate, TeacherSearchValidate searchValidate) {
        Integer pageNo = pageValidate.getPageNo();
        Integer pageSize = pageValidate.getPageSize();

        QueryWrapper<Teachers> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("teacher_id");

        if(searchValidate.getTeacherId() != null){
            queryWrapper.eq("teacher_id",searchValidate.getTeacherId());
        }
        else if (!searchValidate.getName().equals("")){
            queryWrapper.eq("name",searchValidate.getName());
        }
        else if (!searchValidate.getDegree().equals("")){
            queryWrapper.eq("degree",searchValidate.getDegree());
            if (!searchValidate.getMajor().equals("")){
                queryWrapper.eq("major",searchValidate.getMajor());
            }
        }
        else if(!searchValidate.getMajor().equals("")){
            queryWrapper.eq("major",searchValidate.getMajor());
        }
        Page<Teachers> teacherPage = teacherMapper.selectPage(new Page<>(pageNo, pageSize), queryWrapper.eq("is_delete",0));

        List<TeacherListVo> list = new LinkedList<>();
        for (Teachers stu: teacherPage.getRecords()) {
            TeacherListVo vo = new TeacherListVo();
            BeanUtils.copyProperties(stu,vo);
            vo.setTeacherId(stu.getTeacherId());
            list.add(vo);
        }

        return T.success(list, (int)teacherPage.getTotal());
    }

    @Override
    public TeacherDetailVo teacherDetail(Integer teacherId) {
        Teachers teachers = teacherMapper.selectOne(new QueryWrapper<Teachers>()
                .eq("teacher_id", teacherId)
                .last("limit 1"));
        TeacherDetailVo teacherDetailVo = new TeacherDetailVo();
        BeanUtils.copyProperties(teachers,teacherDetailVo);
        teacherDetailVo.setTeacher_id(teachers.getTeacherId());
        return teacherDetailVo;
    }

    @Override
    public void teacherEdit(TeacherUpdateValidate teacherUpdateValidate) {
        Teachers teachers = teacherMapper.selectOne(new QueryWrapper<Teachers>()
                .eq("teacher_id", teacherUpdateValidate.getTeacherId())
                .last("limit 1"));
        teachers.setEmail(teacherUpdateValidate.getEmail());
        teachers.setAddress(teacherUpdateValidate.getAddress());
        teachers.setPhone(teacherUpdateValidate.getPhone());
        teachers.setSalary(teacherUpdateValidate.getSalary());
        teachers.setDegree(teacherUpdateValidate.getDegree());
        teachers.setMajor(teacherUpdateValidate.getMajor());
        teachers.setUpdateTime(LocalDateTime.now());
        teacherMapper.updateById(teachers);
    }

    @Override
    public void teacherAdd(TeacherCreateValidate createValidate) {
        Teachers teachers = new Teachers();
        teachers.setId(UUID.randomUUID().toString());
        QueryWrapper<Teachers> QueryWrapper = new QueryWrapper<Teachers>().orderByDesc("teacher_id");
        Teachers teachers1 = teacherMapper.selectOne(QueryWrapper.last("limit 1"));
        Integer teacherId = teachers1.getTeacherId();
        teachers.setTeacherId(teacherId + 1);
        teachers.setName(createValidate.getName());
        teachers.setPassword(Md5Utils.encode(createValidate.getPassword()));
        teachers.setAddress(createValidate.getAddress());
        teachers.setSex(createValidate.getSex());
        teachers.setBirthDate(createValidate.getBirthDate());
        teachers.setEmail(createValidate.getEmail());
        teachers.setPhone(createValidate.getPhone());
        teachers.setHireDate(createValidate.getHireDate());
        teachers.setSalary(createValidate.getSalary());
        teachers.setDegree(createValidate.getDegree());
        teachers.setMajor(createValidate.getMajor());
        teachers.setCreateTime(LocalDateTime.now());
        teachers.setUpdateTime(LocalDateTime.now());
        teacherMapper.insert(teachers);
    }

    @Override
    public void teacherDelete(Integer teacherId) {
        Teachers teachers = teacherMapper.selectOne(new QueryWrapper<Teachers>()
                .eq("teacher_id", teacherId));
        teachers.setIsDelete(1);
        teachers.setDeleteTime(LocalDateTime.now());
        teacherMapper.updateById(teachers);
    }
}
