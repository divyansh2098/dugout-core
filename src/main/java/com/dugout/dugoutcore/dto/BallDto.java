package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.models.Innings;
import com.dugout.dugoutcore.models.User;
import com.dugout.dugoutcore.pojo.enums.BallType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BallDto {
    Innings innings;
    User striker;
    User nonStriker;
    User bowler;
    User wicketKeeper;
    Boolean isValid;
    Long runs;
    BallType type;
    Integer ballNumber;
    Long batsmanRuns;
    Boolean isFreeHit;
    String comment;
    WicketDto wicket;
}
