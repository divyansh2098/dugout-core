package com.dugout.dugoutcore.dto;

import lombok.Data;

@Data
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
}
