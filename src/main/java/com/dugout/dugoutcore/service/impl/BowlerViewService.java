package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dao.BowlerViewDao;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.dto.BallUnprocessRequestDto;
import com.dugout.dugoutcore.dto.BowlerViewDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.BallProcessingService;
import com.dugout.dugoutcore.util.BallProcessingUtils;
import org.springframework.stereotype.Service;

@Service
public class BowlerViewService implements BallProcessingService<BowlerViewDto> {
  private BowlerViewDao bowlerViewDao;
  private UserService userService;
  private BallProcessingUtils ballProcessingUtils;

  @Override
  public BowlerViewDto processNoBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // Bowler's extras and runs will increase
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + 1);
    if (request.getRuns() != null && request.getRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processNoBallLegBye(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    // Bowler's extras and runs will increase
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + 1);
    if (request.getRuns() != null && request.getRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processNoBallBye(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    // Bowler's extras and runs will increase
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + 1);
    if (request.getRuns() != null && request.getRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processWideBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // Bowler's extras and runs will increase
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + 1);
    if (request.getRuns() != null && request.getRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processWideBallBye(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // Bowler's extras and runs will increase
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + 1);
    if (request.getRuns() != null && request.getRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processFourRuns(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // Bowler runs will increase
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + 4);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processSixRuns(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // Bowler runs will increase
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + 6);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processRun(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // Bowler runs will increase
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getRuns());
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processLegBye(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // Bowler runs will increase
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getRuns());
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processWicket(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // Bowler wickets will increase
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processStumpAndWide(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // bowlers wicket and runs will increase
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + 1);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processRunOut(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    if (request.getRuns() != null && request.getRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processRunOutAndWide(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + 1);
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + 1);
    if (request.getRuns() != null && request.getRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processRunOutAndNoBall(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + 1);
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + 1);
    if (request.getRuns() != null && request.getRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processObstructingTheFieldAndWide(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + 1);
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + 1);
    if (request.getRuns() != null && request.getRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto processObstructingTheFieldAndNoBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    BowlerViewDto bowlerViewDto = bowlerViewDao.getPlayerBowlerViewFromInningAndPlayer(request.getInningId(), request.getBowlerId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + 1);
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + 1);
    if (request.getRuns() != null && request.getRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getRuns());
    }
    return bowlerViewDao.update(bowlerViewDto);
  }

  @Override
  public BowlerViewDto unprocessNoBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessNoBallLegBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessNoBallBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessWideBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessWideBallBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessFourRuns(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessSixRuns(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessRun(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessLegBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessBowled(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessCatch(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessCaughtAndBowled(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessStump(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessStumpAndWide(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessRunOut(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessRunOutAndWide(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessRunOutAndNoBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessWideTimedOutWicket(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessObstructingTheField(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessObstructingTheFieldAndWide(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessObstructingTheFieldAndNoBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessCaughtBehind(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessLegByWicket(BallUnprocessRequestDto request) {
    return null;
  }
}
