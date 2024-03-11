package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.MatchStatus;

public class MatchResponseDto {
  String name;
  String city;
  String country;
  Integer overs;
  Long tossWinnerId;
  TournamentDto tournament;
  TeamDto team1;
  TeamDto team2;
  GroundDto groundId;
  MatchStatus matchStatus;
}
