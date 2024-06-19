package com.fdzc.javaeeserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("dormitoryfix")
public class Dormitoryfix implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "repair_id", type = IdType.AUTO)
    private Integer repairId;

    @TableField("dormitory_id")
    private Integer dormitoryId;

    @TableField("student_id")
    private Integer studentId;

    @TableField("repair_date")
    private LocalDate repairDate;

    @TableField("repair_reason")
    private String repairReason;

    @TableField("repai_state")
    private String repaiState;
}
