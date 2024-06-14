package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.entity.Teacher;
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

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public T teacherList(PageValidate pageValidate, TeacherSearchValidate searchValidate) {
        Integer pageNo = pageValidate.getPageNo();
        Integer pageSize = pageValidate.getPageSize();

        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("teacher_id");

        if(searchValidate.getTeacherId() != null){
            queryWrapper.eq("teacher_id",searchValidate.getTeacherId());
        }
        else if (searchValidate.getName() != null){
            queryWrapper.eq("name",searchValidate.getName());
        }
        else if (searchValidate.getDegree()!= null){
            queryWrapper.eq("degree",searchValidate.getDegree());
            if (searchValidate.getMajor()!= null){
                queryWrapper.eq("major",searchValidate.getMajor());
            }
        }
        else if(searchValidate.getMajor()!= null){
            queryWrapper.eq("major",searchValidate.getMajor());
        }
        Page<Teacher> teacherPage = teacherMapper.selectPage(new Page<>(pageNo, pageSize), queryWrapper);

        List<TeacherListVo> list = new LinkedList<>();
        for (Teacher stu: teacherPage.getRecords()) {
            TeacherListVo vo = new TeacherListVo();
            BeanUtils.copyProperties(stu,vo);
            list.add(vo);
        }

        return T.success(list, (int)teacherPage.getTotal());
    }

    @Override
    public TeacherDetailVo teacherDetail(Integer teacherId) {
        Teacher teacher = teacherMapper.selectOne(new QueryWrapper<Teacher>()
                .eq("teacher_id", teacherId)
                .last("limit 1"));
        TeacherDetailVo teacherDetailVo = new TeacherDetailVo();
        BeanUtils.copyProperties(teacher,teacherDetailVo);
        return teacherDetailVo;
    }

    @Override
    public void teacherEdit(TeacherUpdateValidate teacherUpdateValidate) {
        Teacher teacher = teacherMapper.selectOne(new QueryWrapper<Teacher>()
                .eq("teacher_id", teacherUpdateValidate.getTeacherId())
                .last("limit 1"));
        teacher.setEmail(teacherUpdateValidate.getEmail());
        teacher.setAddress(teacherUpdateValidate.getAddress());
        teacher.setPhone(teacherUpdateValidate.getPhone());
        teacher.setSalary(teacherUpdateValidate.getSalary());
        teacher.setDegree(teacherUpdateValidate.getDegree());
        teacher.setMajor(teacherUpdateValidate.getMajor());
        teacher.setUpdateTime(LocalDateTime.now());
        teacherMapper.updateById(teacher);
    }

    @Override
    public void teacherAdd(TeacherCreateValidate createValidate) {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(createValidate.getTeacherId());
        teacher.setName(createValidate.getName());
        teacher.setPassword(Md5Utils.encode(createValidate.getPassword()));
        teacher.setAddress(createValidate.getAddress());
        teacher.setSex(createValidate.getSex());
        teacher.setBirthDate(createValidate.getBirthDate());
        teacher.setEmail(createValidate.getEmail());
        teacher.setPhone(createValidate.getPhone());
        teacher.setHireDate(createValidate.getHireDate());
        teacher.setSalary(createValidate.getSalary());
        teacher.setDegree(createValidate.getDegree());
        teacher.setMajor(createValidate.getMajor());
        teacher.setCreateTime(LocalDateTime.now());
        teacher.setUpdateTime(LocalDateTime.now());
        teacherMapper.insert(teacher);
    }

    @Override
    public void teacherDelete(Integer teacherId) {
        Teacher teacher = teacherMapper.selectOne(new QueryWrapper<Teacher>()
                .eq("teacher_id", teacherId));
        teacher.setIsDelete(1);
        teacher.setDeleteTime(LocalDateTime.now());
        teacherMapper.updateById(teacher);
    }
}
