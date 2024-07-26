package com.dugout.dugoutcore.service.impl.views;

import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.dto.InningDto;
import com.dugout.dugoutcore.dto.UserDTO;
import com.dugout.dugoutcore.dto.WicketDto;
import com.dugout.dugoutcore.dto.WicketMetaRequestDto;
import com.dugout.dugoutcore.pojo.enums.BallType;
import com.dugout.dugoutcore.pojo.enums.WicketType;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BaseViewServiceTest {

  protected BallProcessRequestDto getBallProcessRequestDto() {
    BallProcessRequestDto requestDto = new BallProcessRequestDto();
    requestDto.setBallNumber(1);
    requestDto.setInningId(1L);
    requestDto.setBowlerId(3L);
    requestDto.setWicketKeeperId(2L);
    requestDto.setStrikerId(1L);
    requestDto.setRuns(1);
    requestDto.setComment("Played for a single");
    requestDto.setIsFreeHit(false);
    requestDto.setBallType(BallType.RUN);
    requestDto.setNonStrikerId(4L);
    return requestDto;
  }

  protected WicketMetaRequestDto getSampleWicketMetaRequestDto(WicketType wicketType) {
    WicketMetaRequestDto wicketMetaRequestDto = new WicketMetaRequestDto();
    wicketMetaRequestDto.setWicketType(wicketType);
    wicketMetaRequestDto.setFielderId(1L);
    wicketMetaRequestDto.setOutPlayerId(2L);
    wicketMetaRequestDto.setFielderId(3L);
    return wicketMetaRequestDto;
  }

  protected BallDto getSampleBallDto() {
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    return BallDto.builder()
        .ballNumber(ballProcessRequestDto.getBallNumber())
        .inning(getSampleInning())
        .striker(getSampleUser())
        .nonStriker(getSampleUser())
        .bowler(getSampleUser())
        .wicketKeeper(getSampleUser())
        .type(ballProcessRequestDto.getBallType())
        .isFreeHit(ballProcessRequestDto.getIsFreeHit())
        .comment(ballProcessRequestDto.getComment())
        .build();
  }

  protected WicketDto getSampleWicketDto(WicketType wicketType) {
    WicketMetaRequestDto wicketMetaRequestDto = getSampleWicketMetaRequestDto(wicketType);
    return WicketDto.builder()
        .fielder(getSampleUser())
        .outPlayer(getSampleUser())
        .innings(getSampleInning())
        .ball(getSampleBallDto())
        .type(wicketMetaRequestDto.getWicketType())
        .build();
  }

  protected InningDto getSampleInning() {
    return new InningDto();
  }

  protected UserDTO getSampleUser() {
    return new UserDTO();
  }
}
