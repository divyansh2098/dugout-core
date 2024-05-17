package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.models.Ball;
import com.dugout.dugoutcore.pojo.enums.BallType;
import lombok.Data;

@Data
public class BallUnprocessRequestDto extends BallUnprocessRequest {
  Long ballId;
  String requester;
}
