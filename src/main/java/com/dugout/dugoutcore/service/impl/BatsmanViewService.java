package com.dugout.dugoutcore.service.impl;

import static com.dugout.dugoutcore.ApplicationConstants.FOUR_RUNS;
import static com.dugout.dugoutcore.ApplicationConstants.SIX_RUNS;

import com.dugout.dugoutcore.dao.BatsmanViewDao;
import com.dugout.dugoutcore.dto.*;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.BallProcessingService;
import com.dugout.dugoutcore.util.BallProcessingUtils;
import com.dugout.dugoutcore.util.BatsmanViewUtils;
import java.util.Objects;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BatsmanViewService
    implements BallProcessingService<
        BatsmanViewDto, BatsmanViewProcessDto, BatsmanViewUnprocessDto> {
  @NonNull private BatsmanViewDao batsmanViewDao;
  @NonNull private UserService userService;
  @NonNull private BallProcessingUtils ballProcessingUtils;

  @NonNull private BatsmanViewUtils batsmanViewUtils;

  @Override
  public BatsmanViewDto processNoBall(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // Batsmen view will only change if there are some runs from batsmen
    BatsmanViewDto strikerBatsmanViewDto = null;
    if (request.getBallDto().getBatsmanRuns() != null
        && request.getBallDto().getBatsmanRuns() > 0) {
      strikerBatsmanViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              request.getBallDto().getInning().getId(), request.getBallDto().getStriker().getId());
      batsmanViewUtils.increaseBatsmanRuns(
          strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
      batsmanViewUtils.incrementBallsFaced(strikerBatsmanViewDto);
      strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    }
    return strikerBatsmanViewDto;
  }

  @Override
  public BatsmanViewDto processNoBallLegBye(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            ballDto.getInning().getId(), ballDto.getStriker().getId());
    batsmanViewUtils.incrementBallsFaced(strikerBatsmanViewDto);
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processNoBallBye(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            ballDto.getInning().getId(), ballDto.getStriker().getId());
    batsmanViewUtils.incrementBallsFaced(strikerBatsmanViewDto);
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processWideBall(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // nothing will be done here
    return null;
  }

  @Override
  public BatsmanViewDto processWideBallBye(BatsmanViewProcessDto request) {
    // nothing will be done here
    return null;
  }

  @Override
  public BatsmanViewDto processFourRuns(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // adds 4 runs to the striker runs and increment num ball
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            request.getBallDto().getInning().getId(), request.getBallDto().getStriker().getId());
    ;
    batsmanViewUtils.increaseBatsmanRuns(strikerBatsmanViewDto, FOUR_RUNS);
    batsmanViewUtils.incrementBallsFaced(strikerBatsmanViewDto);
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processSixRuns(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // adds 6 runs to the striker runs and increment num ball
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            request.getBallDto().getInning().getId(), request.getBallDto().getStriker().getId());
    ;
    strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() + SIX_RUNS);
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processRun(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // adds given runs to the striker runs and increment num ball
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            request.getBallDto().getInning().getId(), request.getBallDto().getStriker().getId());
    strikerBatsmanViewDto.setRuns(
        strikerBatsmanViewDto.getRuns() + request.getBallDto().getBatsmanRuns());
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processLegBye(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // nothing will be done here except increasing the num balls
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            request.getBallDto().getInning().getId(), request.getBallDto().getStriker().getId());
    batsmanViewUtils.incrementBallsFaced(strikerBatsmanViewDto);
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processWicket(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and add runs to striker if any and increment num balls for
    // striker
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            request.getBallDto().getInning().getId(), request.getBallDto().getStriker().getId());
    ;
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    if (request.getBallDto().getBatsmanRuns() != null
        && request.getBallDto().getBatsmanRuns() > 0) {
      batsmanViewUtils.increaseBatsmanRuns(
          strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
    }
    if (request
        .getBallDto()
        .getWicket()
        .getOutPlayer()
        .getId()
        .equals(request.getBallDto().getStriker().getId())) {
      batsmanViewUtils.markBatsmanOut(strikerBatsmanViewDto, request.getBallDto().getWicket());
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              request.getBallDto().getInning().getId(),
              request.getBallDto().getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
      batsmanViewDao.update(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processStumpAndWide(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out
    BatsmanViewDto outPlayerViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            request.getBallDto().getInning().getId(),
            request.getBallDto().getWicket().getOutPlayer().getId());
    batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
    return batsmanViewDao.update(outPlayerViewDto);
  }

  @Override
  public BatsmanViewDto processRunOut(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any and incrementing num balls
    // for striker
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            request.getBallDto().getInning().getId(), request.getBallDto().getStriker().getId());
    ;
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    if (request.getBallDto().getBatsmanRuns() != null
        && request.getBallDto().getBatsmanRuns() > 0) {
      batsmanViewUtils.increaseBatsmanRuns(
          strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
    }
    if (request
        .getBallDto()
        .getWicket()
        .getOutPlayer()
        .getId()
        .equals(request.getBallDto().getStriker().getId())) {
      batsmanViewUtils.markBatsmanOut(strikerBatsmanViewDto, request.getBallDto().getWicket());
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              request.getBallDto().getInning().getId(),
              request.getBallDto().getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
      batsmanViewDao.update(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processRunOutAndWide(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            request.getBallDto().getInning().getId(), request.getBallDto().getStriker().getId());
    if (request
        .getBallDto()
        .getWicket()
        .getOutPlayer()
        .getId()
        .equals(request.getBallDto().getStriker().getId())) {
      batsmanViewUtils.markBatsmanOut(strikerBatsmanViewDto, request.getBallDto().getWicket());
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              request.getBallDto().getInning().getId(),
              request.getBallDto().getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
      batsmanViewDao.update(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processRunOutAndNoBall(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            request.getBallDto().getInning().getId(), request.getBallDto().getStriker().getId());
    ;
    if (request.getBallDto().getBatsmanRuns() != null
        && request.getBallDto().getBatsmanRuns() > 0) {
      batsmanViewUtils.increaseBatsmanRuns(
          strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
    }
    if (request
        .getBallDto()
        .getWicket()
        .getOutPlayer()
        .getId()
        .equals(request.getBallDto().getStriker().getId())) {
      batsmanViewUtils.markBatsmanOut(strikerBatsmanViewDto, request.getBallDto().getWicket());
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              request.getBallDto().getInning().getId(),
              request.getBallDto().getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
      batsmanViewDao.update(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processObstructingTheFieldAndWide(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            request.getBallDto().getInning().getId(), request.getBallDto().getStriker().getId());
    ;
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    if (request.getBallDto().getBatsmanRuns() != null
        && request.getBallDto().getBatsmanRuns() > 0) {
      batsmanViewUtils.increaseBatsmanRuns(
          strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
    }
    if (request
        .getBallDto()
        .getWicket()
        .getOutPlayer()
        .getId()
        .equals(request.getBallDto().getStriker().getId())) {
      batsmanViewUtils.markBatsmanOut(strikerBatsmanViewDto, request.getBallDto().getWicket());
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              request.getBallDto().getInning().getId(),
              request.getBallDto().getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
      batsmanViewDao.update(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processObstructingTheFieldAndNoBall(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            request.getBallDto().getInning().getId(), request.getBallDto().getStriker().getId());
    ;
    if (request.getBallDto().getBatsmanRuns() != null
        && request.getBallDto().getBatsmanRuns() > 0) {
      batsmanViewUtils.increaseBatsmanRuns(
          strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
    }
    if (request
        .getBallDto()
        .getWicket()
        .getOutPlayer()
        .getId()
        .equals(request.getBallDto().getStriker().getId())) {
      batsmanViewUtils.markBatsmanOut(strikerBatsmanViewDto, request.getBallDto().getWicket());
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              request.getBallDto().getInning().getId(),
              request.getBallDto().getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
      batsmanViewDao.update(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto unprocessNoBall(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            ballDto.getInning().getId(), ballDto.getStriker().getId());
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() - 1);
    strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() - ballDto.getBatsmanRuns());
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto unprocessNoBallLegBye(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            ballDto.getInning().getId(), ballDto.getStriker().getId());
    batsmanViewUtils.decrementBallsFaced(strikerBatsmanViewDto);
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto unprocessNoBallBye(BatsmanViewUnprocessDto request) {
    // Nothing to be updated here
    return null;
  }

  @Override
  public BatsmanViewDto unprocessWideBall(BatsmanViewUnprocessDto request) {
    // Nothing to be done here
    return null;
  }

  @Override
  public BatsmanViewDto unprocessWideBallBye(BatsmanViewUnprocessDto request) {
    // nothing to be done here
    return null;
  }

  @Override
  public BatsmanViewDto unprocessFourRuns(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessSixRuns(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessRun(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            ballDto.getInning().getId(), ballDto.getStriker().getId());
    batsmanViewUtils.decreaseBatsmanRuns(
        strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
    batsmanViewUtils.decrementBallsFaced(strikerBatsmanViewDto);
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto unprocessLegBye(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            ballDto.getInning().getId(), ballDto.getStriker().getId());
    batsmanViewUtils.decrementBallsFaced(strikerBatsmanViewDto);
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto unprocessBowled(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            ballDto.getInning().getId(), ballDto.getStriker().getId());
    batsmanViewUtils.decrementBallsFaced(strikerBatsmanViewDto);
    batsmanViewUtils.markBatsmanAsNotOut(strikerBatsmanViewDto);
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto unprocessCatch(BatsmanViewUnprocessDto request) {
    // Not used
    return null;
  }

  @Override
  public BatsmanViewDto unprocessCaughtAndBowled(BatsmanViewUnprocessDto request) {
    // Not used
    return null;
  }

  @Override
  public BatsmanViewDto unprocessStump(BatsmanViewUnprocessDto request) {
    // Not used
    return null;
  }

  @Override
  public BatsmanViewDto unprocessStumpAndWide(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            ballDto.getInning().getId(), ballDto.getStriker().getId());
    batsmanViewUtils.markBatsmanAsNotOut(strikerBatsmanViewDto);
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto unprocessRunOut(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            ballDto.getInning().getId(), ballDto.getStriker().getId());
    batsmanViewUtils.decreaseBatsmanRuns(strikerBatsmanViewDto, ballDto.getBatsmanRuns());
    batsmanViewUtils.decrementBallsFaced(strikerBatsmanViewDto);
    if (Objects.equals(ballDto.getWicket().getOutPlayer().getId(), ballDto.getStriker().getId())) {
      batsmanViewUtils.markBatsmanAsNotOut(strikerBatsmanViewDto);
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              ballDto.getInning().getId(), ballDto.getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanAsNotOut(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto unprocessRunOutAndWide(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            ballDto.getInning().getId(), ballDto.getStriker().getId());
    if (Objects.equals(ballDto.getWicket().getOutPlayer().getId(), ballDto.getStriker().getId())) {
      batsmanViewUtils.markBatsmanAsNotOut(strikerBatsmanViewDto);
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              ballDto.getInning().getId(), ballDto.getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanAsNotOut(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto unprocessRunOutAndNoBall(BatsmanViewUnprocessDto request) {
    // Not used. un process run out covers all the cases
    return null;
  }

  @Override
  public BatsmanViewDto unprocessObstructingTheField(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            ballDto.getInning().getId(), ballDto.getStriker().getId());
    batsmanViewUtils.decreaseBatsmanRuns(strikerBatsmanViewDto, ballDto.getBatsmanRuns());
    batsmanViewUtils.decrementBallsFaced(strikerBatsmanViewDto);
    if (Objects.equals(ballDto.getWicket().getOutPlayer().getId(), ballDto.getStriker().getId())) {
      batsmanViewUtils.markBatsmanAsNotOut(strikerBatsmanViewDto);
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              ballDto.getInning().getId(), ballDto.getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanAsNotOut(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto unprocessObstructingTheFieldAndWide(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            ballDto.getInning().getId(), ballDto.getStriker().getId());
    if (Objects.equals(ballDto.getWicket().getOutPlayer().getId(), ballDto.getStriker().getId())) {
      batsmanViewUtils.markBatsmanAsNotOut(strikerBatsmanViewDto);
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              ballDto.getInning().getId(), ballDto.getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanAsNotOut(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto unprocessObstructingTheFieldAndNoBall(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    BatsmanViewDto strikerBatsmanViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            ballDto.getInning().getId(), ballDto.getStriker().getId());
    batsmanViewUtils.decreaseBatsmanRuns(strikerBatsmanViewDto, ballDto.getBatsmanRuns());
    batsmanViewUtils.decrementBallsFaced(strikerBatsmanViewDto);
    if (Objects.equals(ballDto.getWicket().getOutPlayer().getId(), ballDto.getStriker().getId())) {
      batsmanViewUtils.markBatsmanAsNotOut(strikerBatsmanViewDto);
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              ballDto.getInning().getId(), ballDto.getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanAsNotOut(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto unprocessCaughtBehind(BatsmanViewUnprocessDto request) {
    // No need
    return null;
  }

  @Override
  public BatsmanViewDto unprocessLegBeforeWicket(BatsmanViewUnprocessDto request) {
    // No need
    return null;
  }
}
