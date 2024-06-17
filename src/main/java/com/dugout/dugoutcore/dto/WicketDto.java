package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.WicketType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WicketDto extends BaseDto {
  InningDto innings;
  BallDto ball;
  UserDTO outPlayer;
  UserDTO fielder;
  WicketType type;
}
