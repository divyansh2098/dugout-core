package com.dugout.dugoutcore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "team")
@Data
public class Team extends BaseModel {
  String name;

  @OneToMany(mappedBy = "team")
  List<TournamentTeam> tournaments;
}
