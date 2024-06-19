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
 * @author 何安琪
 * @since 2024-06-07
 */
@Getter
@Setter
@TableName("logistics")
public class Logistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("repair_id")
    private Integer repairId;

    @TableField("equipment_id")
    private Integer equipmentId;

    @TableField("repair_date")
    private LocalDate repairDate;

    @TableField("status")
    private String status;
}
