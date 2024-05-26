package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.MatchStatus;
import com.dugout.dugoutcore.pojo.enums.TossDecision;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchDto extends BaseDto {
  String name;
  String city;
  String country;
  Integer overs;
  Long tossWinnerId;
  
  TossDecision tossDecision;
  TournamentDto tournament;
  TeamDto team1;
  TeamDto team2;
  GroundDto ground;
  MatchStatus status;
  List<SquadPlayerDto> squad1Players;
  List<SquadPlayerDto> squad2Players;
}
