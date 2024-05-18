package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dao.BowlerViewDao;
import com.dugout.dugoutcore.dto.*;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.BallProcessingService;
import com.dugout.dugoutcore.util.BallProcessingUtils;
import org.springframework.stereotype.Service;

import static com.dugout.dugoutcore.ApplicationConstants.*;

@Service
public class BowlerViewService
    implements BallProcessingService<BowlerViewDto, BowlerViewProcessDto, BowlerViewUnprocessDto> {
  private BowlerViewDao bowlerViewDao;
  private UserService userService;
  private BallProcessingUtils ballProcessingUtils;

  @Override
  public BowlerViewDto processNoBall(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler's extras and runs will increase
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processNoBallLegBye(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler's extras and runs will increase
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processNoBallBye(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler's extras and runs will increase
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processWideBall(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler's extras and runs will increase
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processWideBallBye(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler's extras and runs will increase
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processFourRuns(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler runs will increase
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + FOUR_RUNS);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processSixRuns(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler runs will increase
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + SIX_RUNS);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processRun(BowlerViewProcessDto request) throws DugoutDataFetchingException {
    // Bowler runs will increase
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processLegBye(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler runs will increase
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processWicket(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler wickets will increase
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processStumpAndWide(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // bowlers wicket and runs will increase
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processRunOut(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processRunOutAndWide(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processRunOutAndNoBall(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processObstructingTheFieldAndWide(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processObstructingTheFieldAndNoBall(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    BowlerViewDto bowlerViewDto =
        bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(
            request.getBallDto().getInnings().getId(), request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto unprocessNoBall(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessNoBallLegBye(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessNoBallBye(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessWideBall(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessWideBallBye(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessFourRuns(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessSixRuns(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessRun(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessLegBye(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessBowled(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessCatch(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessCaughtAndBowled(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessStump(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessStumpAndWide(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessRunOut(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessRunOutAndWide(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessRunOutAndNoBall(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessWideTimedOutWicket(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessObstructingTheField(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessObstructingTheFieldAndWide(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessObstructingTheFieldAndNoBall(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessCaughtBehind(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessLegByWicket(BowlerViewUnprocessDto request) {
    return null;
  }
}
