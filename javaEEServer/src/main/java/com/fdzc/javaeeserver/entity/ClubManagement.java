package com.fdzc.javaeeserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.w3c.dom.Text;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClubManagement {
    private Integer clubId;
    private String clubName;
    private Integer activityId;
    private Text announcement;
}
