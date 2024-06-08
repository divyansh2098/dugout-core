package com.dugout.dugoutcore.models;

import com.dugout.dugoutcore.pojo.enums.WicketType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "wicket")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Wicket extends BaseModel {
  @ManyToOne
  @JoinColumn(name = "inning_id")
  Inning inning;

  @OneToOne
  @JoinColumn(name = "ball_id")
  Ball ball;

  @ManyToOne
  @JoinColumn(name = "out_player_id")
  User outPlayer;

  @OneToOne
  @JoinColumn(name = "fielder_id")
  User fielder;

  @Enumerated(EnumType.STRING)
  WicketType type;
}
