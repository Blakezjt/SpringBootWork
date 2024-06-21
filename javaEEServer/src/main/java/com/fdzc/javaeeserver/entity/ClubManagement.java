package com.fdzc.javaeeserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId
    private Integer clubId;
    private String clubName;
    private Integer activityId;
    private Text announcement;
}
