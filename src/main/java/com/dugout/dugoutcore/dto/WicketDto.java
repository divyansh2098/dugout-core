package com.dugout.dugoutcore.dto;

import com.dugout.dugoutcore.models.Innings;
import com.dugout.dugoutcore.models.User;
import com.dugout.dugoutcore.pojo.enums.WicketType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WicketDto {
    Innings innings;
    BallDto ball;
    User outPlayer;
    WicketType type;
}
