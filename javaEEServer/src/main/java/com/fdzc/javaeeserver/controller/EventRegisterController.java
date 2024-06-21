package com.fdzc.javaeeserver.controller;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.EventRegistration;
import com.fdzc.javaeeserver.service.EventRegisterService;
import com.fdzc.javaeeserver.vo.event.EventVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class EventRegisterController {

    @Autowired
    private EventRegisterService eventRegisterService;

    // 查看所有活动
    @GetMapping("/getAllEvent")
    public R getAllEvent() {
        List<EventRegistration> list = eventRegisterService.getAllEvent();
        return new R(200,"查询成功",list);
    }

    // 报名活动
    @PostMapping("/registerEvent")
    public R registerEvent(@RequestParam Integer studentId, @RequestParam Integer eventId) {
        boolean success = eventRegisterService.registerEvent(studentId, eventId);
        return success ? new R(200, "报名成功",success) : new R(500, "报名失败",success);
    }

    // 活动提醒
    @PostMapping("/notifyEvent")
    public R notifyEvent(@RequestParam Integer studentId, @RequestParam Integer eventId) {
        boolean success = eventRegisterService.notifyEvent(studentId, eventId);
        return success ? new R(200, "提醒成功",success) : new R(500, "提醒失败",success);
    }
}
