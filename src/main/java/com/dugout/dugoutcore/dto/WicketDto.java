package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.WicketType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class WicketDto {
  InningsDto innings;
  BallDto ball;
  UserDTO outPlayer;
  UserDTO fielder;
  WicketType type;
}
