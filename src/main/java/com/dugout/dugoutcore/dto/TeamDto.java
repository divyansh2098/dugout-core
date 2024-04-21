package com.dugout.dugoutcore.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TeamDto extends BaseDto {
  Long id;
  String name;
  Date createdOn;
  Date updatedOn;
}
