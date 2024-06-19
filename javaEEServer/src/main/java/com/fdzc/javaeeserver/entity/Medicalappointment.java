package com.fdzc.javaeeserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 陈嘉诚
 * @since 2024-06-11
 */
@Getter
@Setter
@TableName("medicalappointment")
public class Medicalappointment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("appointment_id")
    private Integer appointmentId;

    @TableField("student_id")
    private Integer studentId;

    @TableField("student_name")
    private String studentName;

    @TableField("appointment_time")
    private LocalDate appointmentTime;

    @TableField("reason")
    private String reason;
}
