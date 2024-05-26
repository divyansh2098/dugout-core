package com.dugout.dugoutcore.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "squad_player")
@Data
public class SquadPlayer extends BaseModel {
  @Column(name = "team_id")
  Long teamId;

  @Column(name = "match_id")
  Long matchId;

  @ManyToOne
  @JoinColumn(name = "player_id")
  User player;
}
