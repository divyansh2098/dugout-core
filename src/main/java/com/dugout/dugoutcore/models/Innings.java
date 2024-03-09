package com.dugout.dugoutcore.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "innings")
@Data
public class Innings extends BaseModel {
  @ManyToOne
  @JoinColumn(name = "match_id")
  Match match;

  @ManyToOne
  @JoinColumn(name = "team_id")
  Team team;

  @Column(name = "inning_number")
  Integer inningNumber;

  Date startTime;
  Date endTime;

  @Column(name = "score_agg")
  String scoreAgg;
}
