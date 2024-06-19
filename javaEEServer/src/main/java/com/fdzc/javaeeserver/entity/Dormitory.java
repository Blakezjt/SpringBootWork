package com.fdzc.javaeeserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("dormitory")
public class Dormitory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dormitory_id", type = IdType.AUTO)
    private Integer dormitoryId;

    @TableField("building_name")
    private String buildingName;

    @TableField("dorm_name")
    private String dormName;

    @TableField("type")
    private Integer type;

    @TableField("available")
    private Integer available;
}
