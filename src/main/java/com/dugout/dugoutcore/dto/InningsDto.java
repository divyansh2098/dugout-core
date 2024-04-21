package com.dugout.dugoutcore.dto;

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
  String scoreAgg;
}
