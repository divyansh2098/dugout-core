package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.TeamPlayerRole;
import lombok.Data;

@Data
public class AddPlayerToTeamRequestDto {
  Long playerId;
  Long teamId;
  TeamPlayerRole teamPlayerRole;
}
