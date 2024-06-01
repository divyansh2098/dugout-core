package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.InningStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InningsDto extends BaseDto {
  MatchDto matchDto;
  TeamDto teamDto;
  Integer inningNumber;
  Date startTime;
  Date endTime;
  InningStatus status;
  Integer score;
  Integer wickets;
  Integer numBalls;
  Integer target;
  Integer extras;
}
