package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.pojo.enums.InningStatus;
import java.util.Date;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InningDto extends BaseDto {
  Long matchId;
  TeamDto team;
  Integer inningNumber;
  Date startTime;
  Date endTime;
  Integer score;
  Integer wickets;
  Integer target;
  Integer numBalls;
  Integer extras;
  InningStatus status;
}
