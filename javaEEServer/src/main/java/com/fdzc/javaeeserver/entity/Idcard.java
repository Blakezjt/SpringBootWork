package com.fdzc.javaeeserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

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
@TableName("idcard")
public class Idcard implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id_card_id")
    private String idCardId;

    @TableField("student_id")
    private Integer studentId;

    @TableField("issue_date")
    private LocalDate issueDate;

    @TableField("expiration_date")
    private LocalDate expirationDate;
}
