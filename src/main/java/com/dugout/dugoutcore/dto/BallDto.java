package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.BallType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BallDto extends BaseDto {
  InningDto inning;
  UserDTO striker;
  UserDTO nonStriker;
  UserDTO bowler;
  UserDTO keeper;
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
