package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.MatchStatus;
import com.dugout.dugoutcore.pojo.enums.MatchType;
import com.dugout.dugoutcore.pojo.enums.TossDecision;

import java.util.Date;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchDto extends BaseDto {
  String name;
  String city;
  String country;
  Integer overs;
  Date matchDate;
  Long tossWinnerId;
  Set<InningDto> innings;
  TossDecision tossDecision;
  TournamentDto tournament;
  TeamDto team1;
  TeamDto team2;
  GroundDto ground;
  MatchStatus status;
  MatchType type;
  List<SquadPlayerDto> squad1Players;
  List<SquadPlayerDto> squad2Players;
  List<PowerPlay> powerplay;
}
