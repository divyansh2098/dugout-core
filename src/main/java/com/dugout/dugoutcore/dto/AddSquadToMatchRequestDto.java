package com.dugout.dugoutcore.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddSquadToMatchRequestDto {
  Long matchId;
  Long teamId;
  List<Long> playerIds;
}
