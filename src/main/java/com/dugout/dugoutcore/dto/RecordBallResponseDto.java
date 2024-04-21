package com.dugout.dugoutcore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RecordBallResponseDto {
  Long strikerId;
  Long nonStrikerId;
  Boolean success;
  Boolean isNextFreeHit;
  Integer nextBallNumber;
  Boolean isOverComplete;
}
