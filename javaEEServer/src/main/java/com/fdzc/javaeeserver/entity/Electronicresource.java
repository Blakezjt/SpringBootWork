package com.fdzc.javaeeserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName("electronicresource")
public class Electronicresource {

    @TableId("resource_id")
    private Integer resourceId;
    private String resourceName;
    private String type;
    private String url;

}
