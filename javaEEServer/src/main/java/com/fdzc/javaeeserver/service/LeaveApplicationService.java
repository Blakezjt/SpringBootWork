package com.fdzc.javaeeserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fdzc.javaeeserver.entity.LeaveApplication;

public interface LeaveApplicationService extends IService<LeaveApplication> {
    public boolean add(LeaveApplication leaveApplication);
    public IPage<LeaveApplication> teacherlist(Page<LeaveApplication> page);

    public IPage<LeaveApplication> studentlist(Integer studentId, Page<LeaveApplication> page);

    public boolean deletebyId(Integer id);

    IPage<LeaveApplication> studentlist2(String approvalStatus, Page<LeaveApplication> leaveApplicationPagepage);
}
