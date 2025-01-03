package com.dugout.dugoutcore.models;

import com.dugout.dugoutcore.pojo.enums.BallType;
import jakarta.persistence.*;
import java.util.Date;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "ball")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ball extends BaseModel {

  @ManyToOne
  @JoinColumn(name = "inning_id")
  Inning inning;

  @ManyToOne
  @JoinColumn(name = "striker")
  User striker;

  @ManyToOne
  @JoinColumn(name = "non_striker")
  User nonStriker;

  @ManyToOne
  @JoinColumn(name = "bowler")
  User bowler;

  @ManyToOne
  @JoinColumn(name = "wicket_keeper")
  User wicketKeeper;

  @Column(name = "is_valid")
  Boolean isValid;

  Long runs;

  @Enumerated(EnumType.STRING)
  BallType type;

  @Column(name = "ball_number")
  Integer ballNumber;

  @Column(name = "batsman_run")
  Long batsmanRuns;

  @Column(name = "bowler_run")
  Long bowlerRuns;

  @Column(name = "is_free_hit")
  Boolean isFreeHit;

  String comment;

  @Column(name = "deleted_on")
  Date deletedOn;

  @Column(name = "deleted_by")
  String deletedBy;
}
