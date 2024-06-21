package com.fdzc.javaeeserver.service.impl;

import com.fdzc.javaeeserver.entity.EventRegistration;
import com.fdzc.javaeeserver.mapper.EventRegisterMapper;
import com.fdzc.javaeeserver.service.EventRegisterService;
import com.fdzc.javaeeserver.vo.event.EventVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventRegisterServiceImpl implements EventRegisterService {

    @Autowired
    private EventRegisterMapper eventRegisterMapper;

    @Override
    public List<EventRegistration> getAllEvent() {
        return eventRegisterMapper.selectList(null);
    }

    @Override
    public boolean registerEvent(Integer studentId, Integer eventId) {
        // 创建报名对象
        EventRegistration eventRegistration = new EventRegistration();
        eventRegistration.setStudentId(studentId);
        eventRegistration.setEventId(eventId);
        eventRegistration.setAnnouncement(LocalDateTime.now());

        // 插入报名记录
        int result = eventRegisterMapper.insert(eventRegistration);

        // 判断是否插入成功
        return result > 0;
    }

    @Override
    public boolean notifyEvent(Integer studentId, Integer eventId) {
        // 根据eventId查询活动信息
        EventRegistration event = eventRegisterMapper.selectById(eventId);
        if (event == null) {
            return false; // 活动不存在
        }

        // 获取活动时间并与当前时间进行比较
        LocalDateTime eventTime = event.getAnnouncement();
        LocalDateTime currentTime = LocalDateTime.now();
        if (eventTime.isAfter(currentTime)) {
            // 活动时间大于当前时间，进行通知
            // 在这里，你可以实现你的通知逻辑，比如发送邮件或者推送消息
            // 目前只返回true或false
            return true;
        }
        return false; // 活动时间已过，不需要提醒
    }
}
