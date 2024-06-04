package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.models.Inning;
import com.dugout.dugoutcore.models.User;
import com.dugout.dugoutcore.pojo.enums.BatsmanViewBatsmanStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class BatsmanViewDto extends BaseDto {

  Inning inning;
  User player;
  Long runs;
  Long numBalls;
  Integer fours;
  Integer sixes;
  BatsmanViewBatsmanStatus status;

  WicketDto wicket;
  Boolean isStriker;
  Date startTime;
  Date endTime;
}
