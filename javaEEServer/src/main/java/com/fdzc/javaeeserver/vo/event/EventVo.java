package com.fdzc.javaeeserver.vo.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventVo {
    // 报名ID
    private Integer registrationId;
    // 学生ID
    private Integer studentId;
    // 活动ID
    private Integer eventId;

    // 报名时间
    private LocalDateTime announcement;
}
