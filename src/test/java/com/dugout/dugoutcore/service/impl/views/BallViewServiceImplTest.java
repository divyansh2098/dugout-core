package com.dugout.dugoutcore.service.impl.views;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.dugout.dugoutcore.dao.BallDao;
import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.service.BallDtoConverter;
import com.dugout.dugoutcore.service.WicketDtoConverter;
import com.dugout.dugoutcore.service.impl.WicketService;
import com.dugout.dugoutcore.util.BallProcessingUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

class BallViewServiceImplTest extends BaseViewServiceTest {

  @InjectMocks BallViewServiceImpl ballViewService;

  @Mock private WicketService wicketService;
  @Mock private BallDao ballDao;
  @Spy private BallDtoConverter ballDtoConverter;
  @Mock private WicketDtoConverter wicketDtoConverter;
  @Mock private BallProcessingUtils ballProcessingUtils;

  @Test
  @SneakyThrows
  void processNoBall() {
    when(ballDao.create(any(BallDto.class))).thenReturn(null);
    BallProcessRequestDto requestDto = getBallProcessRequestDto();
    BallDto responseDto = ballViewService.processNoBall(requestDto);
    verify(ballDao, times(1)).create(ballDtoArgumentCaptor.capture());
    BallDto createdDto = ballDtoArgumentCaptor.getValue();
    assertEquals(1, createdDto.getBatsmanRuns());
  }

  @Test
  void processNoBallLegBye() {}

  @Test
  void processNoBallBye() {}

  @Test
  void processWideBall() {}

  @Test
  void processWideBallBye() {}

  @Test
  void processFourRuns() {}

  @Test
  void processSixRuns() {}

  @Test
  void processRun() {}

  @Test
  void processLegBye() {}

  @Test
  void processWicket() {}

  @Test
  void processStumpAndWide() {}

  @Test
  void processRunOut() {}

  @Test
  void processRunOutAndWide() {}

  @Test
  void processRunOutAndNoBall() {}

  @Test
  void processObstructingTheField() {}

  @Test
  void processObstructingTheFieldAndWide() {}

  @Test
  void processObstructingTheFieldAndNoBall() {}

  @Test
  void unprocessNoBall() {}

  @Test
  void unprocessNoBallLegBye() {}

  @Test
  void unprocessNoBallBye() {}

  @Test
  void unprocessWideBall() {}

  @Test
  void unprocessWideBallBye() {}

  @Test
  void unprocessFourRuns() {}

  @Test
  void unprocessSixRuns() {}

  @Test
  void unprocessRun() {}

  @Test
  void unprocessLegBye() {}

  @Test
  void unprocessBowled() {}

  @Test
  void unprocessCatch() {}

  @Test
  void unprocessCaughtAndBowled() {}

  @Test
  void unprocessStump() {}

  @Test
  void unprocessStumpAndWide() {}

  @Test
  void unprocessRunOut() {}

  @Test
  void unprocessRunOutAndWide() {}

  @Test
  void unprocessRunOutAndNoBall() {}

  @Test
  void unprocessObstructingTheField() {}

  @Test
  void unprocessObstructingTheFieldAndWide() {}

  @Test
  void unprocessObstructingTheFieldAndNoBall() {}

  @Test
  void unprocessCaughtBehind() {}

  @Test
  void unprocessLegBeforeWicket() {}

  @Test
  void unprocessBall() {}
}
