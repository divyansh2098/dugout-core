package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.BallType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BallDto extends BaseDto {
  InningDto inning;
  UserDTO striker;
  UserDTO nonStriker;
  UserDTO bowler;
  UserDTO wicketKeeper;
  Boolean isValid;
  Integer runs;
  BallType type;
  Integer ballNumber;
  Integer batsmanRuns;
  Integer bowlerRuns;
  Boolean isFreeHit;
  String comment;
  Integer nextBallNumber;
  Boolean isNextFreeHit;
  Boolean isOverComplete;
  @JsonIgnoreProperties("ball")
  WicketDto wicket;
  Date deletedOn;
  String deletedBy;
}
