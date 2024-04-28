package com.dugout.dugoutcore.models;

import com.dugout.dugoutcore.pojo.enums.WicketType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Wicket extends BaseModel {
  @ManyToOne
  @JoinColumn(name = "inning_id")
  Innings innings;

  @OneToOne
  @JoinColumn(name = "ball_id")
  Ball ball;

  @ManyToOne
  @JoinColumn(name = "out_player_id")
  User outPlayer;

  @OneToOne
  @Column(name = "fielder_id")
  User fielder;

  @Enumerated(EnumType.STRING)
  WicketType type;
}
