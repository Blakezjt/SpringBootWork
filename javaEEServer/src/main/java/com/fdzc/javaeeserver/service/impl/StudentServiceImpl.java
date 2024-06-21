package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.entity.Student;
import com.fdzc.javaeeserver.entity.Teachers;
import com.fdzc.javaeeserver.mapper.StudentMapper;
import com.fdzc.javaeeserver.service.StudentService;
import com.fdzc.javaeeserver.utils.Md5Utils;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.validate.student.StudentCreateValidate;
import com.fdzc.javaeeserver.validate.student.StudentUpdateValidate;
import com.fdzc.javaeeserver.vo.student.StudentDetailVo;
import com.fdzc.javaeeserver.validate.student.StudentSearchValidate;
import com.fdzc.javaeeserver.vo.student.StudentListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public T studentList(PageValidate pageValidate, StudentSearchValidate searchValidate) {
        Integer pageNo = pageValidate.getPageNo();
        Integer pageSize = pageValidate.getPageSize();

        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("student_id");

        if(searchValidate.getStudentId() != null){
            queryWrapper.eq("student_id",searchValidate.getStudentId());
        }
        else if (!searchValidate.getStudentName().equals("")){
            queryWrapper.eq("student_name",searchValidate.getStudentName());
        }
        else if (!searchValidate.getStudentDept().equals("")){
            queryWrapper.eq("student_dept",searchValidate.getStudentDept());
        }
        else if (!searchValidate.getStudentXb().equals("")){
            queryWrapper.eq("student_xb",searchValidate.getStudentXb());
        }

        Page<Student> studentPage = studentMapper.selectPage(new Page<>(pageNo, pageSize),
                queryWrapper.eq("is_delete",0));
        List<StudentListVo> list = new LinkedList<>();
        for (Student stu: studentPage.getRecords()) {
            StudentListVo vo = new StudentListVo();
            BeanUtils.copyProperties(stu,vo);
            String formattedDate = formatter.format(stu.getEntryTime());
            vo.setEntryTime(formattedDate);
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
        studentDetailVo.setEntryTime(formatter.format(student.getEntryTime()));
        BeanUtils.copyProperties(student,studentDetailVo);
        return studentDetailVo;
    }

    @Override
    public void studentEdit(StudentUpdateValidate studentUpdateValidate) {
        Student student = studentMapper.selectOne(new QueryWrapper<Student>()
                .eq("student_id", studentUpdateValidate.getStudentId())
                .last("limit 1"));
        student.setStudentDept(studentUpdateValidate.getStudentDept());
        student.setStudentXb(studentUpdateValidate.getStudentXb());
        student.setDormitoryId(studentUpdateValidate.getDormitoryId());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateById(student);
    }

    @Override
    public void studentAdd(StudentCreateValidate createValidate) {
        Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        QueryWrapper<Student> QueryWrapper = new QueryWrapper<Student>().orderByDesc("student_id");
        Student student1 = studentMapper.selectOne(QueryWrapper.last("limit 1"));
        Integer studentId = student1.getStudentId();
        student.setStudentId(studentId + 1);
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
