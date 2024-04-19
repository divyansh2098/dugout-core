package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.BallType;
import lombok.Data;

@Data
public class BaseBallProcessRequest {
    BallType ballType;
    Long inningId;
    Integer ballNo;
    Long bowlerId;
    Long wicketkeeperId;
    Long strikerId;
    Long nonStrikerId;
    String comment;
}
