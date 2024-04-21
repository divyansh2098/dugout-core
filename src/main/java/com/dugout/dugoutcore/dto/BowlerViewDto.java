package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.models.Innings;
import com.dugout.dugoutcore.models.User;
import com.dugout.dugoutcore.pojo.enums.BowlerViewBowlerStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class BowlerViewDto extends BaseDto {
    Innings innings;
    User player;
    Long runs;
    Long numBalls;
    Integer fours;
    Integer sixes;
    BowlerViewBowlerStatus status;
    Integer wickets;
}
