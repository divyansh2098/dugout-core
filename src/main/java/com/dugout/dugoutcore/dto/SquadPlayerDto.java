package com.dugout.dugoutcore.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SquadPlayerDto extends BaseDto {
  Long teamId;
  UserDTO player;
  Long matchId;
}
