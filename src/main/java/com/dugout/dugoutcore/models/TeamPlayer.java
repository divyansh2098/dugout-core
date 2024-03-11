package com.dugout.dugoutcore.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "team_player")
@Data
public class TeamPlayer extends BaseModel {
  @ManyToOne
  @JoinColumn(name = "user_id")
  User user;

  @ManyToOne
  @JoinColumn(name = "team_id")
  Team team;

  String teamRole;
}
