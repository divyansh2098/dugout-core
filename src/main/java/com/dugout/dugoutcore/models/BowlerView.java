package com.dugout.dugoutcore.models;

import com.dugout.dugoutcore.pojo.enums.BowlerViewBowlerStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "bowler_view")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BowlerView extends BaseModel {

  @ManyToOne
  @JoinColumn(name = "inning_id")
  Inning inning;

  @ManyToOne
  @JoinColumn(name = "player_id")
  User player;

  Long runs;

  @Column(name = "num_balls")
  Long numBalls;

  Integer fours;

  Integer sixes;

  Integer extras;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  BowlerViewBowlerStatus status;

  Integer wickets;
}