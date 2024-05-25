package com.dugout.dugoutcore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDto {
  String firstName;
  String lastName;
  String userName;
  String email;
  String phone;
  String gender;
  String dob;
  String country;
  String city;
  String specialisation;
  String battingStyle;
  String bowlingStyle;
  @JsonIgnoreProperties("player")
  List<TeamPlayerDto> teams;
}
