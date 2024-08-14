package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.MatchStatus;
import com.dugout.dugoutcore.pojo.enums.MatchType;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MatchRequestDto {
  String name;
  String city;
  String country;
  Integer overs;
  Date matchDate;
  Long tossWinnerId;
  Long tournamentId;
  Long team1Id;
  Long team2Id;
  Long groundId;
  MatchStatus status;
  MatchType type;
  List<PowerPlay> powerplay;
}
