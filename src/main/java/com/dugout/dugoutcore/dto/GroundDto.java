package com.dugout.dugoutcore.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GroundDto {
  String name;
  Long id;
  String lat;
  String lon;
  String address;
  Date createdOn;
  Date updatedOn;
}
