package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.LeaveApplication;
import com.fdzc.javaeeserver.entity.Medicalappointment;
import com.fdzc.javaeeserver.mapper.MedicalappointmentMapper;
import com.fdzc.javaeeserver.service.MedicalappointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 陈嘉诚
 * @since 2024-06-11
 */
@Service
public class MedicalappointmentServiceImpl extends ServiceImpl<MedicalappointmentMapper, Medicalappointment> implements MedicalappointmentService {

    @Autowired
    MedicalappointmentMapper medicalappointmentMapper;

    @Override
    public boolean add(Medicalappointment medicalappointment) {
        int add = medicalappointmentMapper.insert(medicalappointment);
        if (add!=1){
            return false;
        }
        return true;
    }

    @Override
    public IPage<Medicalappointment> teacherlist(Page<Medicalappointment> page) {
        LambdaQueryWrapper<Medicalappointment> queryWrapper = new LambdaQueryWrapper<>();
        return medicalappointmentMapper.selectPage(page,queryWrapper);
    }

    @Override
    public IPage<Medicalappointment> studentlist(Integer studentId, Page<Medicalappointment> page) {
        LambdaQueryWrapper<Medicalappointment> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.eq(Medicalappointment::getStudentId,studentId);
        return medicalappointmentMapper.selectPage(page,queryWrapper);
    }

    @Override
    public boolean deletebyId(Integer id) {
        int isdelete = medicalappointmentMapper.deleteById(id);
        if (isdelete>0){
            return true;
        } else {
            return false;
        }
    }
}
