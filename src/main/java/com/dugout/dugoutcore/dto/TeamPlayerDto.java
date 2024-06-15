package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.TeamPlayerRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamPlayerDto extends BaseDto {
  @JsonIgnoreProperties("players")
  TeamDto team;
  UserDTO player;
  TeamPlayerRole teamRole;
}
