package com.fdzc.javaeeserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
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
@TableName("healthreport")
public class Healthreport implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("report_id")
    private Integer reportId;

    @TableField("student_id")
    private Integer studentId;

    @TableField("student_name")
    private String studentName;

    @TableField("date")
    private LocalDate date;

    @TableField("health_status")
    private String healthStatus;
}
