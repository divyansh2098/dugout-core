package com.dugout.dugoutcore.service.impl.views;

import static com.dugout.dugoutcore.ApplicationConstants.FOUR_RUNS;
import static com.dugout.dugoutcore.ApplicationConstants.SIX_RUNS;
import static com.dugout.dugoutcore.ApplicationConstants.ZERO_RUNS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.dugout.dugoutcore.dao.BallDao;
import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.dto.BallUnprocessRequestDto;
import com.dugout.dugoutcore.dto.WicketDto;
import com.dugout.dugoutcore.pojo.enums.WicketType;
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
  @Mock private BallDtoConverter ballDtoConverter;
  @Mock private WicketDtoConverter wicketDtoConverter;
  @Spy private BallProcessingUtils ballProcessingUtils;

  @Test
  @SneakyThrows
  void processNoBall() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    BallDto responseDto = ballViewService.processNoBall(getBallProcessRequestDto());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getBowlerRuns());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getRuns());
    assertEquals(true, responseDto.getIsNextFreeHit());
    assertEquals(ballProcessRequestDto.getRuns(), responseDto.getBatsmanRuns());
    assertEquals(ballProcessRequestDto.getBallNumber(), responseDto.getNextBallNumber());
  }

  @Test
  @SneakyThrows
  void processNoBallLegBye() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    BallDto responseDto = ballViewService.processNoBallLegBye(getBallProcessRequestDto());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getBowlerRuns());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getRuns());
    assertEquals(true, responseDto.getIsNextFreeHit());
    assertEquals(0, responseDto.getBatsmanRuns());
    assertEquals(ballProcessRequestDto.getBallNumber(), responseDto.getNextBallNumber());
  }

  @Test
  @SneakyThrows
  void processNoBallBye() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    BallDto responseDto = ballViewService.processNoBallBye(getBallProcessRequestDto());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getBowlerRuns());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getRuns());
    assertEquals(true, responseDto.getIsNextFreeHit());
    assertEquals(0, responseDto.getBatsmanRuns());
    assertEquals(ballProcessRequestDto.getBallNumber(), responseDto.getNextBallNumber());
  }

  @Test
  @SneakyThrows
  void processWideBall() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    BallDto responseDto = ballViewService.processWideBall(getBallProcessRequestDto());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getBowlerRuns());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getRuns());
    assertEquals(ballProcessRequestDto.getIsFreeHit(), responseDto.getIsNextFreeHit());
    assertEquals(0, responseDto.getBatsmanRuns());
    assertEquals(ballProcessRequestDto.getBallNumber(), responseDto.getNextBallNumber());
  }

  @Test
  @SneakyThrows
  void processFourRuns() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    BallDto responseDto = ballViewService.processFourRuns(getBallProcessRequestDto());
    assertEquals(FOUR_RUNS, responseDto.getBowlerRuns());
    assertEquals(FOUR_RUNS, responseDto.getRuns());
    assertEquals(false, responseDto.getIsNextFreeHit());
    assertEquals(FOUR_RUNS, responseDto.getBatsmanRuns());
    assertEquals(ballProcessRequestDto.getBallNumber() + 1, responseDto.getNextBallNumber());
  }

  @Test
  @SneakyThrows
  void processSixRuns() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    BallDto responseDto = ballViewService.processSixRuns(getBallProcessRequestDto());
    assertEquals(SIX_RUNS, responseDto.getBowlerRuns());
    assertEquals(SIX_RUNS, responseDto.getRuns());
    assertEquals(false, responseDto.getIsNextFreeHit());
    assertEquals(SIX_RUNS, responseDto.getBatsmanRuns());
    assertEquals(ballProcessRequestDto.getBallNumber() + 1, responseDto.getNextBallNumber());
  }

  @Test
  @SneakyThrows
  void processRun() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    BallDto responseDto = ballViewService.processRun(getBallProcessRequestDto());
    assertEquals(ballProcessRequestDto.getRuns(), responseDto.getBowlerRuns());
    assertEquals(ballProcessRequestDto.getRuns(), responseDto.getRuns());
    assertEquals(false, responseDto.getIsNextFreeHit());
    assertEquals(ballProcessRequestDto.getRuns(), responseDto.getBatsmanRuns());
    assertEquals(ballProcessRequestDto.getBallNumber() + 1, responseDto.getNextBallNumber());
  }

  @Test
  @SneakyThrows
  void processLegBye() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    BallDto responseDto = ballViewService.processLegBye(getBallProcessRequestDto());
    assertEquals(ballProcessRequestDto.getRuns(), responseDto.getBowlerRuns());
    assertEquals(ballProcessRequestDto.getRuns(), responseDto.getRuns());
    assertEquals(false, responseDto.getIsNextFreeHit());
    assertEquals(0, responseDto.getBatsmanRuns());
    assertEquals(ballProcessRequestDto.getBallNumber() + 1, responseDto.getNextBallNumber());
  }

  @Test
  @SneakyThrows
  void processWicket() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    WicketDto wicketDto = getSampleWicketDto(WicketType.CATCH);
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(wicketDtoConverter.convertToWicketDto(any(), anyLong())).thenReturn(wicketDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    when(wicketService.create(any(WicketDto.class))).thenReturn(wicketDto);
    BallDto responseDto = ballViewService.processWicket(ballProcessRequestDto);
    assertFalse(responseDto.getIsOverComplete());
    assertNotNull(responseDto.getWicket());
    assertEquals(WicketType.CATCH, responseDto.getWicket().getType());
    assertEquals(ZERO_RUNS, responseDto.getBatsmanRuns());
    assertEquals(ZERO_RUNS, responseDto.getBowlerRuns());
    assertEquals(false, responseDto.getIsFreeHit());
    assertEquals(false, responseDto.getIsNextFreeHit());
  }

  @Test
  @SneakyThrows
  void processStumpAndWide() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    WicketDto wicketDto = getSampleWicketDto(WicketType.STUMP_AND_WIDE);
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(wicketDtoConverter.convertToWicketDto(any(), anyLong())).thenReturn(wicketDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    when(wicketService.create(any(WicketDto.class))).thenReturn(wicketDto);
    BallDto responseDto = ballViewService.processStumpAndWide(ballProcessRequestDto);
    assertFalse(responseDto.getIsOverComplete());
    assertNotNull(responseDto.getWicket());
    assertEquals(WicketType.STUMP_AND_WIDE, responseDto.getWicket().getType());
    assertEquals(1, responseDto.getRuns());
    assertEquals(ZERO_RUNS, responseDto.getBatsmanRuns());
    assertEquals(1, responseDto.getBowlerRuns());
    assertEquals(false, responseDto.getIsNextFreeHit());
  }

  @Test
  @SneakyThrows
  void processRunOut() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    WicketDto wicketDto = getSampleWicketDto(WicketType.RUN_OUT);
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(wicketDtoConverter.convertToWicketDto(any(), anyLong())).thenReturn(wicketDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    when(wicketService.create(any(WicketDto.class))).thenReturn(wicketDto);
    BallDto responseDto = ballViewService.processRunOut(ballProcessRequestDto);
    assertFalse(responseDto.getIsOverComplete());
    assertNotNull(responseDto.getWicket());
    assertEquals(WicketType.RUN_OUT, responseDto.getWicket().getType());
    assertEquals(ballProcessRequestDto.getRuns(), responseDto.getRuns());
    assertEquals(ballProcessRequestDto.getRuns(), responseDto.getBatsmanRuns());
    assertEquals(ballProcessRequestDto.getRuns(), responseDto.getBowlerRuns());
    assertEquals(false, responseDto.getIsNextFreeHit());
  }

  @Test
  @SneakyThrows
  void processRunOutAndWide() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    WicketDto wicketDto = getSampleWicketDto(WicketType.RUN_OUT_AND_WIDE);
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(wicketDtoConverter.convertToWicketDto(any(), anyLong())).thenReturn(wicketDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    when(wicketService.create(any(WicketDto.class))).thenReturn(wicketDto);
    BallDto responseDto = ballViewService.processRunOutAndWide(ballProcessRequestDto);
    assertFalse(responseDto.getIsOverComplete());
    assertNotNull(responseDto.getWicket());
    assertEquals(WicketType.RUN_OUT_AND_WIDE, responseDto.getWicket().getType());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getRuns());
    assertEquals(ZERO_RUNS, responseDto.getBatsmanRuns());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getBowlerRuns());
    assertEquals(false, responseDto.getIsNextFreeHit());
  }

  @Test
  @SneakyThrows
  void processRunOutAndNoBall() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    WicketDto wicketDto = getSampleWicketDto(WicketType.RUN_OUT_AND_NO_BALL);
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(wicketDtoConverter.convertToWicketDto(any(), anyLong())).thenReturn(wicketDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    when(wicketService.create(any(WicketDto.class))).thenReturn(wicketDto);
    BallDto responseDto = ballViewService.processRunOutAndNoBall(ballProcessRequestDto);
    assertFalse(responseDto.getIsOverComplete());
    assertNotNull(responseDto.getWicket());
    assertEquals(WicketType.RUN_OUT_AND_NO_BALL, responseDto.getWicket().getType());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getRuns());
    assertEquals(ballProcessRequestDto.getRuns(), responseDto.getBatsmanRuns());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getBowlerRuns());
    assertEquals(true, responseDto.getIsNextFreeHit());
  }

  @Test
  @SneakyThrows
  void processObstructingTheField() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    WicketDto wicketDto = getSampleWicketDto(WicketType.OBSTRUCTING_THE_FIELD);
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(wicketDtoConverter.convertToWicketDto(any(), anyLong())).thenReturn(wicketDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    when(wicketService.create(any(WicketDto.class))).thenReturn(wicketDto);
    BallDto responseDto = ballViewService.processObstructingTheField(ballProcessRequestDto);
    assertFalse(responseDto.getIsOverComplete());
    assertNotNull(responseDto.getWicket());
    assertEquals(WicketType.OBSTRUCTING_THE_FIELD, responseDto.getWicket().getType());
    assertEquals(ballProcessRequestDto.getRuns(), responseDto.getRuns());
    assertEquals(ballProcessRequestDto.getRuns(), responseDto.getBatsmanRuns());
    assertEquals(ballProcessRequestDto.getRuns(), responseDto.getBowlerRuns());
    assertEquals(false, responseDto.getIsNextFreeHit());
  }

  @Test
  @SneakyThrows
  void processObstructingTheFieldAndWide() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    WicketDto wicketDto = getSampleWicketDto(WicketType.OBSTRUCTING_THE_FIELD_AND_WIDE);
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(wicketDtoConverter.convertToWicketDto(any(), anyLong())).thenReturn(wicketDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    when(wicketService.create(any(WicketDto.class))).thenReturn(wicketDto);
    BallDto responseDto = ballViewService.processObstructingTheFieldAndWide(ballProcessRequestDto);
    assertFalse(responseDto.getIsOverComplete());
    assertNotNull(responseDto.getWicket());
    assertEquals(WicketType.OBSTRUCTING_THE_FIELD_AND_WIDE, responseDto.getWicket().getType());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getRuns());
    assertEquals(0, responseDto.getBatsmanRuns());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getBowlerRuns());
    assertEquals(responseDto.getIsFreeHit(), responseDto.getIsNextFreeHit());
  }

  @Test
  @SneakyThrows
  void processObstructingTheFieldAndNoBall() {
    BallDto ballDto = getSampleBallDto();
    BallProcessRequestDto ballProcessRequestDto = getBallProcessRequestDto();
    WicketDto wicketDto = getSampleWicketDto(WicketType.OBSTRUCTING_THE_FIELD_AND_NO_BALL);
    when(ballDtoConverter.convertBallRequestToBallDto(any(BallProcessRequestDto.class)))
        .thenReturn(ballDto);
    when(wicketDtoConverter.convertToWicketDto(any(), anyLong())).thenReturn(wicketDto);
    when(ballDao.create(any(BallDto.class))).thenReturn(ballDto);
    when(wicketService.create(any(WicketDto.class))).thenReturn(wicketDto);
    BallDto responseDto =
        ballViewService.processObstructingTheFieldAndNoBall(ballProcessRequestDto);
    assertFalse(responseDto.getIsOverComplete());
    assertNotNull(responseDto.getWicket());
    assertEquals(WicketType.OBSTRUCTING_THE_FIELD_AND_NO_BALL, responseDto.getWicket().getType());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getRuns());
    assertEquals(ballProcessRequestDto.getRuns(), responseDto.getBatsmanRuns());
    assertEquals(ballProcessRequestDto.getRuns() + 1, responseDto.getBowlerRuns());
    assertEquals(true, responseDto.getIsNextFreeHit());
  }

  @Test
  @SneakyThrows
  void unprocessBall() {
    BallDto ballDto = getSampleBallDto();
    when(ballDao.getById(anyLong())).thenReturn(ballDto);
    when(ballDao.update(any())).thenReturn(ballDto);
    BallUnprocessRequestDto ballUnprocessRequestDto = new BallUnprocessRequestDto();
    ballUnprocessRequestDto.setBallId(1L);
    ballUnprocessRequestDto.setRequester("TestUser");
    BallDto responseBallDto = ballViewService.unprocessBall(ballUnprocessRequestDto);
    assertEquals("TestUser", responseBallDto.getDeletedBy());
    assertNotNull(responseBallDto.getDeletedOn());
  }
}
