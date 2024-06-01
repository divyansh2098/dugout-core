package com.dugout.dugoutcore.models;

import com.dugout.dugoutcore.pojo.enums.InningStatus;
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

  @Enumerated(value = EnumType.STRING)
  InningStatus status;

  Integer score;

  Integer wickets;

  @Column(name = "num_balls")
  Integer numBalls;

  Integer target;

  Integer extras;
}
