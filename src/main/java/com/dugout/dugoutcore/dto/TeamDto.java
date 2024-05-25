package com.dugout.dugoutcore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamDto extends BaseDto {
  Long id;
  String name;
  Date createdOn;
  Date updatedOn;

  @JsonIgnoreProperties("team")
  List<TeamPlayerDto> players;
}
