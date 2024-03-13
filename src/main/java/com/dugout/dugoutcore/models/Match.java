package com.dugout.dugoutcore.models;

import com.dugout.dugoutcore.pojo.enums.MatchStatus;
import com.dugout.dugoutcore.pojo.enums.TossDecision;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;
import lombok.Data;

@Entity
@Table(name = "`match`")
@Data
public class Match extends BaseModel {
  String name;
  Integer overs;
  String city;
  String country;

  @Column(name = "toss_win")
  Long tossWin;

  @ManyToOne
  @JoinColumn(name = "tournament_id")
  Tournament tournament;

  @ManyToOne
  @JoinColumn(name = "team1_id")
  Team team1;

  @ManyToOne
  @JoinColumn(name = "team2_id")
  Team team2;

  Date matchDate;

  @OneToMany(mappedBy = "match")
  Set<Innings> innings;

  @Enumerated(EnumType.STRING)
  MatchStatus status;

  @Enumerated(EnumType.STRING)
  TossDecision tossDecision;

  @ManyToOne
  @JoinColumn(name = "ground_id")
  Ground ground;
}
