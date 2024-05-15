package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.BallType;
import lombok.Data;

@Data
public class BallUnprocessRequest {
    BallType ballType;
}
