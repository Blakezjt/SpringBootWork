package com.fdzc.javaeeserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Electronicresource {

    private Integer resourceId;
    private String resourceName;
    private String type;
    private String url;

}
