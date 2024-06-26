package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.WicketType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WicketDto extends BaseDto {
  InningDto innings;

  @JsonIgnoreProperties("wicket")
  BallDto ball;

  UserDTO outPlayer;
  UserDTO fielder;
  WicketType type;
}
