package com.dugout.dugoutcore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "team")
@Getter
@Setter
public class Team extends BaseModel {
  String name;

  @OneToMany
  @JoinColumn(name = "team_id")
  List<TournamentTeam> tournaments;

  @OneToMany(cascade = CascadeType.MERGE)
  @JoinColumn(name = "team_id")
  @JsonIgnoreProperties("team")
  List<TeamPlayer> players;
}
