package com.dugout.dugoutcore.dto;

import java.util.Date;
import lombok.Data;

@Data
public class UserDTO {
    Long id;
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
    Date createdOn;
    Date updatedOn;
}
