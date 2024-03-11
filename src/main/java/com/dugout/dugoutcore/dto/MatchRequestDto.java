package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.MatchStatus;
import lombok.Data;

@Data
public class MatchRequestDto {
  String name;
  String city;
  String country;
  Integer overs;
  Long tossWinnerId;
  Long tournamentId;
  Long team1Id;
  Long team2Id;
  Long groundId;
  MatchStatus matchStatus;
}
