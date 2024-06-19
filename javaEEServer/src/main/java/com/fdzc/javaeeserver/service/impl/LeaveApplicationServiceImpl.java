package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fdzc.javaeeserver.entity.LeaveApplication;
import com.fdzc.javaeeserver.mapper.LeaveApplicationMapper;
import com.fdzc.javaeeserver.service.LeaveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveApplicationServiceImpl extends ServiceImpl<LeaveApplicationMapper, LeaveApplication> implements LeaveApplicationService {
    @Autowired
    LeaveApplicationMapper leaveApplicationMapper;

    @Override
    public boolean add(LeaveApplication leaveApplication) {
        leaveApplication.setApprovalStatus("未审核");
        int add = leaveApplicationMapper.insert(leaveApplication);
        if (add!=1){
            return false;
        }
        return true;
    }

    @Override
    public IPage<LeaveApplication> teacherlist(Page<LeaveApplication> page) {
        LambdaQueryWrapper<LeaveApplication> queryWrapper = new LambdaQueryWrapper<>();
        return leaveApplicationMapper.selectPage(page,queryWrapper);
    }

    @Override
    public IPage<LeaveApplication> studentlist(Integer studentId, Page<LeaveApplication> page) {
        LambdaQueryWrapper<LeaveApplication> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.eq(LeaveApplication::getStudentId,studentId);
        return leaveApplicationMapper.selectPage(page,queryWrapper);
    }

    @Override
    public boolean deletebyId(Integer id) {
        int isdelete = leaveApplicationMapper.deleteById(id);
        if (isdelete>0){
            return true;
        } else {
            return false;
        }
    }
}
