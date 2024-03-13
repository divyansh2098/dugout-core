package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.TournamentStatus;
import lombok.Data;

@Data
public class TournamentDto {
  Long id;
  String name;
  String city;
  String country;

  TournamentStatus status;
}
