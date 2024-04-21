package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.MatchStatus;
import lombok.Data;

@Data
public class MatchDto extends BaseDto{
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
}
