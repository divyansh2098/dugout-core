package com.dugout.dugoutcore.service.impl.views;

import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.pojo.enums.BallType;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BaseViewServiceTest {

  @Captor
  ArgumentCaptor<BallDto> ballDtoArgumentCaptor;

  protected BallProcessRequestDto getBallProcessRequestDto() {
    BallProcessRequestDto requestDto = new BallProcessRequestDto();
    requestDto.setBallNumber(1);
    requestDto.setInningId(1L);
    requestDto.setBowlerId(3L);
    requestDto.setWicketKeeperId(2L);
    requestDto.setStrikerId(1L);
    requestDto.setComment("Played for a single");
    requestDto.setIsFreeHit(false);
    requestDto.setBallType(BallType.RUN);
    requestDto.setNonStrikerId(4L);
    return requestDto;
  }
}
