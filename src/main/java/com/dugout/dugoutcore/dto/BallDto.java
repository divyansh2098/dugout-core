package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.BallType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class BallDto {
  InningsDto innings;
  UserDTO striker;
  UserDTO nonStriker;
  UserDTO bowler;
  UserDTO wicketKeeper;
  Boolean isValid;
  Integer runs;
  BallType type;
  Integer ballNumber;
  Integer batsmanRuns;
  Boolean isFreeHit;
  String comment;
  Integer nextBallNumber;
  Boolean isNextFreeHit;
  Boolean isOverComplete;
  WicketDto wicket;
}
