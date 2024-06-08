package com.dugout.dugoutcore.models;

import com.dugout.dugoutcore.pojo.enums.BatsmanViewBatsmanStatus;
import jakarta.persistence.*;
import java.util.Date;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "batsman_view")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BatsmanView extends BaseModel {

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

  @OneToOne
  @JoinColumn(name = "wicket")
  Wicket wicket;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  BatsmanViewBatsmanStatus status;

  @Column(name = "is_striker")
  Boolean isStriker;

  @Column(name = "start_time")
  Date startTime;

  @Column(name = "end_time")
  Date endTime;
}
