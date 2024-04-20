package com.dugout.dugoutcore.dto;

import lombok.Data;

@Data
public class RecordBallResponseDto {
  Long strikerId;
  Long nonStrikerId;
  Boolean success;
}
