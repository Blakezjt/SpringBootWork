package com.fdzc.javaeeserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fdzc.javaeeserver.entity.LeaveApplication;

public interface LeaveApplicationService extends IService<LeaveApplication> {
    public boolean add(LeaveApplication leaveApplication);
}
