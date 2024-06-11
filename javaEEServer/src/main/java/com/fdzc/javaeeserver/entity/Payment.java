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
@TableName("payment")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("payment_id")
    private Integer paymentId;

    @TableField("student_id")
    private Integer studentId;

    @TableField("payment_type")
    private String paymentType;

    @TableField("amount")
    private BigDecimal amount;

    @TableField("payment_date")
    private LocalDate paymentDate;
}
