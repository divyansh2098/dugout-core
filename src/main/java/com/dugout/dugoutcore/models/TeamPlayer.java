package com.dugout.dugoutcore.models;

import com.dugout.dugoutcore.pojo.enums.TeamPlayerRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "team_player")
@Getter
@Setter
public class TeamPlayer extends BaseModel {
  @ManyToOne
  @JoinColumn(name = "user_id")
  User player;

  @ManyToOne
  @JoinColumn(name = "team_id")
  Team team;

  @Enumerated(EnumType.STRING)
  TeamPlayerRole teamRole;
}
