package com.dugout.dugoutcore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "`user`")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseModel {

  @Column(name = "firstname")
  String firstName;

  @Column(name = "lastname")
  String lastName;

  @Column(name = "username")
  String userName;

  @Column(name = "email")
  String email;

  @Column(name = "phone")
  String phone;

  @Column(name = "gender")
  String gender;

  @Column(name = "date_of_birth")
  String dob;

  @Column(name = "country")
  String country;

  @Column(name = "city")
  String city;

  @Column(name = "specialisation")
  String specialisation;

  @Column(name = "batting_style")
  String battingStyle;

  @Column(name = "bowling_style")
  String bowlingStyle;

  @OneToMany
  @JoinColumn(name = "user_id")
  @JsonIgnoreProperties("player")
  List<TeamPlayer> teams;
}
