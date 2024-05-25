package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.TeamPlayerRole;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamPlayerDto extends BaseDto {
  TeamDto team;
  UserDTO player;
  TeamPlayerRole teamRole;
}
