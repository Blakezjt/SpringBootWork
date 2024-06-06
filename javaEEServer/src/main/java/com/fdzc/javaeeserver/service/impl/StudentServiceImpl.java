package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.entity.Student;
import com.fdzc.javaeeserver.mapper.StudentMapper;
import com.fdzc.javaeeserver.service.StudentService;
import com.fdzc.javaeeserver.utils.Md5Utils;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.validate.student.StudentCreateValidate;
import com.fdzc.javaeeserver.vo.student.StudentDetailVo;
import com.fdzc.javaeeserver.validate.student.StudentSearchValidate;
import com.fdzc.javaeeserver.vo.student.StudentListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public T studentList(PageValidate pageValidate, StudentSearchValidate searchValidate) {
        Integer pageNo = pageValidate.getPageNo();
        Integer pageSize = pageValidate.getPageSize();

        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("student_id");

        if(searchValidate.getStudentId() != null){
            queryWrapper.eq("student_id",searchValidate.getStudentId());
        }
        else if (searchValidate.getStudentName() != null){
            queryWrapper.eq("student_name",searchValidate.getStudentName());
        }
        else if (searchValidate.getStudentXb()!= null){
            queryWrapper.eq("student_xb",searchValidate.getStudentXb());
            if (searchValidate.getStudentDept()!= null){
                queryWrapper.eq("student_dept",searchValidate.getStudentDept());
            }
        }
        Page<Student> studentPage = studentMapper.selectPage(new Page<>(pageNo, pageSize), queryWrapper);

        List<StudentListVo> list = new LinkedList<>();
        for (Student stu: studentPage.getRecords()) {
            StudentListVo vo = new StudentListVo();
            BeanUtils.copyProperties(stu,vo);
            list.add(vo);
        }


        return T.success(list, (int) studentPage.getTotal());
    }

    @Override
    public StudentDetailVo studentDetail(Integer studentId) {
        Student student = studentMapper.selectOne(new QueryWrapper<Student>()
                .eq("student_id", studentId)
                .last("limit 1"));
        StudentDetailVo studentDetailVo = new StudentDetailVo();
        BeanUtils.copyProperties(student,studentDetailVo);
        return studentDetailVo;
    }

    @Override
    public void studentAdd(StudentCreateValidate createValidate) {
        Student student = new Student();
        student.setStudentId(createValidate.getStudentId());
        student.setPassword(Md5Utils.encode(createValidate.getPassword()));
        student.setStudentName(createValidate.getStudentName());
        student.setStudentSex(createValidate.getStudentSex());
        student.setStudentXb(createValidate.getStudentXb());
        student.setStudentDept(createValidate.getStudentDept());
        student.setDormitoryId(createValidate.getDormitoryId());
        student.setStudentPhone(createValidate.getStudentPhone());
        student.setEntryTime(createValidate.getEntryTime());
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    @Override
    public void studentDelete(Integer studentId) {
        Student student = studentMapper.selectOne(new QueryWrapper<Student>()
                .eq("student_id", studentId));
        student.setIsDelete(1);
        student.setDeleteTime(LocalDateTime.now());
        studentMapper.updateById(student);
    }
}
