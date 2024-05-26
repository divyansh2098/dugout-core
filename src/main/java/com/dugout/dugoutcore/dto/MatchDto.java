package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.MatchStatus;
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
  TournamentDto tournament;
  TeamDto team1;
  TeamDto team2;
  GroundDto ground;
  MatchStatus status;
  List<SquadPlayerDto> squad1Players;
  List<SquadPlayerDto> squad2Players;
}
