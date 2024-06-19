package com.fdzc.javaeeserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventRegistration {
    // 报名ID
    @TableId
    private Integer registrationId;
    // 学生ID
    private Integer studentId;
    // 活动ID
    private Integer eventId;
    // 报名时间
    private LocalDateTime announcement;
}
