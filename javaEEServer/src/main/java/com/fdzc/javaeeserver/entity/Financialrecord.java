package com.fdzc.javaeeserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 何安琪
 * @since 2024-06-07
 */
@Getter
@Setter
@TableName("financialrecord")
public class Financialrecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("record_id")
    private Integer recordId;

    @TableField("student_id")
    private Integer studentId;

    @TableField("transaction_type")
    private String transactionType;

    @TableField("amount")
    private BigDecimal amount;

    @TableField("date")
    private LocalDate date;
}
