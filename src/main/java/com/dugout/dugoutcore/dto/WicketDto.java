package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.WicketType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WicketDto {
  InningsDto innings;
  BallDto ball;
  UserDTO outPlayer;
  WicketType type;
}
