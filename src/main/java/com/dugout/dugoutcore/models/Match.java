package com.dugout.dugoutcore.models;

import com.dugout.dugoutcore.dto.PowerPlay;
import com.dugout.dugoutcore.pojo.enums.MatchStatus;
import com.dugout.dugoutcore.pojo.enums.MatchType;
import com.dugout.dugoutcore.pojo.enums.TossDecision;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "`match`")
@Getter
@Setter
public class Match extends BaseModel {
  String name;
  Integer overs;
  String city;
  String country;

  @Column(name = "toss_win")
  Long tossWinnerId;

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

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "match_id")
  Set<Inning> innings;

  @Enumerated(EnumType.STRING)
  MatchStatus status;

  @Enumerated(EnumType.STRING)
  MatchType type;

  @Type(JsonType.class)
  @Column(columnDefinition = "json")
  List<PowerPlay> powerplay;

  @Enumerated(EnumType.STRING)
  TossDecision tossDecision;

  @ManyToOne
  @JoinColumn(name = "ground_id")
  Ground ground;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "match_id", referencedColumnName = "id")
  @JoinColumn(name = "team_id", referencedColumnName = "team1_id")
  List<SquadPlayer> squad1Players;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "match_id", referencedColumnName = "id")
  @JoinColumn(name = "team_id", referencedColumnName = "team2_id")
  List<SquadPlayer> squad2Players;
}
