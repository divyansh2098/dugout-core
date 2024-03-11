package com.dugout.dugoutcore.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tournament_team")
@Data
public class TournamentTeam extends BaseModel {

  // Add a constraint on backend on uniqueness of tournament_id and team_id

  @ManyToOne
  @JoinColumn(name = "tournament_id")
  Tournament tournament;

  @ManyToOne
  @JoinColumn(name = "team_id")
  Team team;

  @Column(name = "tournament_position")
  Integer tournamentPosition;
}
