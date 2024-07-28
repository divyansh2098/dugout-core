package com.dugout.dugoutcore.models;

import com.dugout.dugoutcore.pojo.enums.InningStatus;
import jakarta.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "innings")
@Getter
@Setter
public class Inning extends BaseModel {
  @Column(name = "match_id")
  Long matchId;

  @ManyToOne
  @JoinColumn(name = "team_id")
  Team team;

  @Column(name = "inning_number")
  Integer inningNumber;

  Date startTime;
  Date endTime;

  @Enumerated(EnumType.STRING)
  InningStatus status;

  Integer score;

  Integer wickets;
  Integer numBalls;

  Integer target;

  Integer extras;
}
