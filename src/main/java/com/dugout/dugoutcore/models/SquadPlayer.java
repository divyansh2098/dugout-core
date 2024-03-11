package com.dugout.dugoutcore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "squad_player")
@Data
public class SquadPlayer extends BaseModel {
  Long teamId;
  Long matchId;
  Long playerId;
}
