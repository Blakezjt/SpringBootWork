package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Emergencycontact;
import com.fdzc.javaeeserver.entity.LeaveApplication;
import com.fdzc.javaeeserver.mapper.EmergencycontactMapper;
import com.fdzc.javaeeserver.service.EmergencycontactService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fdzc.javaeeserver.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 陈嘉诚
 * @since 2024-06-11
 */
@Service
public class EmergencycontactServiceImpl extends ServiceImpl<EmergencycontactMapper, Emergencycontact> implements EmergencycontactService {

    @Autowired
    EmergencycontactMapper emergencycontactMapper;

    @Override
    public boolean add(Emergencycontact emergencycontact) {
        int add = emergencycontactMapper.insert(emergencycontact);
        if (add != 1) {
            return false;
        }
        return true;
    }

    @Override
    public IPage<Emergencycontact> studentlist(Integer id, Page<Emergencycontact> page) {
        LambdaQueryWrapper<Emergencycontact> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.eq(Emergencycontact::getStudentId,id);
        return emergencycontactMapper.selectPage(page,queryWrapper);
    }

    @Override
    public IPage<Emergencycontact> teacherlist(Page<Emergencycontact> page) {
        LambdaQueryWrapper<Emergencycontact> queryWrapper =new LambdaQueryWrapper<>();
        return emergencycontactMapper.selectPage(page,queryWrapper);
    }

    @Override
    public boolean deletebyId(Integer id) {
        int delete = emergencycontactMapper.deleteById(id);
        if (delete>0){
            return true;
        } else {
            return false;
        }
    }
}
