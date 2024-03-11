package com.dugout.dugoutcore.models;

import com.dugout.dugoutcore.pojo.enums.TournamentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tournament")
@Data
public class Tournament extends BaseModel {
  String name;

  String city;

  String country;

  @OneToMany(mappedBy = "tournament")
  List<Match> matches;

  @OneToMany(mappedBy = "tournament")
  List<TournamentTeam> tournamentTeams;

  @Enumerated(EnumType.STRING)
  TournamentStatus status;
}
