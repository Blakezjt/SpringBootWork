package com.fdzc.javaeeserver.service.impl;

import com.fdzc.javaeeserver.entity.EventRegistration;
import com.fdzc.javaeeserver.vo.event.EventVo;

import java.util.List;

public interface EventRegisterService {
    List<EventRegistration> getAllEvent();

    boolean registerEvent(Integer studentId, Integer eventId);

    boolean notifyEvent(Integer studentId, Integer eventId);
}
