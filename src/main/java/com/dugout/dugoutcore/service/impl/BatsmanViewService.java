package com.dugout.dugoutcore.service.impl;

import static com.dugout.dugoutcore.ApplicationConstants.FOUR_RUNS;
import static com.dugout.dugoutcore.ApplicationConstants.SIX_RUNS;

import com.dugout.dugoutcore.dao.BatsmanViewDao;
import com.dugout.dugoutcore.dto.*;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.pojo.enums.BatsmanViewBatsmanStatus;
import com.dugout.dugoutcore.service.BallProcessingService;
import com.dugout.dugoutcore.util.BallProcessingUtils;
import java.util.Date;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;

@Service
public class BatsmanViewService
    implements BallProcessingService<
        BatsmanViewDto, BatsmanViewProcessDto, BatsmanViewUnprocessDto> {
  private BatsmanViewDao batsmanViewDao;
  private UserService userService;
  private BallProcessingUtils ballProcessingUtils;

  @Override
  public BatsmanViewDto processNoBall(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // Batsmen view will only change if there are some runs from batsmen
    BatsmanViewDto strikerBatsmanViewDto = null;
    if (request.getBallDto().getBatsmanRuns() != null && request.getBallDto().getBatsmanRuns() > 0) {
      strikerBatsmanViewDto =
              batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getStriker().getId());
      strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() + request.getBallDto().getBatsmanRuns());
      strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    }
    return strikerBatsmanViewDto;
  }

  @Override
  public BatsmanViewDto processNoBallLegBye(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // nothing will be done here
    return null;
  }

  @Override
  public BatsmanViewDto processNoBallBye(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // nothing will be done here
    return null;
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
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getStriker().getId());;
    strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() + FOUR_RUNS);
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processSixRuns(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // adds 6 runs to the striker runs and increment num ball
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getStriker().getId());;
    strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() + SIX_RUNS);
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processRun(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // adds given runs to the striker runs and increment num ball
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getStriker().getId());;
    strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() + request.getBallDto().getBatsmanRuns());
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processLegBye(BatsmanViewProcessDto request) {
    // nothing will be done here except increasing the num balls
    BatsmanViewDto strikerBatsmanViewDto =
            batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getStriker().getId());
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    return null;
  }

  @Override
  public BatsmanViewDto processWicket(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and add runs to striker if any and increment num balls for striker
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getStriker().getId());;
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    if (request.getBallDto().getBatsmanRuns() != null && request.getBallDto().getBatsmanRuns() > 0) {
      strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() + request.getBallDto().getBatsmanRuns());
    }
    if (request.getBallDto().getWicket().getOutPlayer().getId().equals(request.getBallDto().getStriker().getId())) {
      strikerBatsmanViewDto.setEndTime(new Date());
      strikerBatsmanViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
    } else {
      BatsmanViewDto outPlayerViewDto =
              batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getWicket().getOutPlayer().getId());
      outPlayerViewDto.setEndTime(new Date());
      outPlayerViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
      batsmanViewDao.update(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processStumpAndWide(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out
    BatsmanViewDto outPlayerViewDto =
            batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getWicket().getOutPlayer().getId());
    outPlayerViewDto.setEndTime(new Date());
    outPlayerViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
    return batsmanViewDao.update(outPlayerViewDto);
  }

  @Override
  public BatsmanViewDto processRunOut(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any and incrementing num balls for striker
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getStriker().getId());;
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    if (request.getBallDto().getBatsmanRuns() != null && request.getBallDto().getBatsmanRuns() > 0) {
      strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() + request.getBallDto().getBatsmanRuns());
    }
    if (request.getBallDto().getWicket().getOutPlayer().getId().equals(request.getBallDto().getStriker().getId())) {
      strikerBatsmanViewDto.setEndTime(new Date());
      strikerBatsmanViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
    } else {
      BatsmanViewDto outPlayerViewDto =
              batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getWicket().getOutPlayer().getId());
      outPlayerViewDto.setEndTime(new Date());
      outPlayerViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
      batsmanViewDao.update(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processRunOutAndWide(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getStriker().getId());;
    if (request.getBallDto().getBatsmanRuns() != null && request.getBallDto().getBatsmanRuns() > 0) {
      strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() + request.getBallDto().getBatsmanRuns());
    }
    if (request.getBallDto().getWicket().getOutPlayer().getId().equals(request.getBallDto().getStriker().getId())) {
      strikerBatsmanViewDto.setEndTime(new Date());
      strikerBatsmanViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
    } else {
      BatsmanViewDto outPlayerViewDto =
              batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getWicket().getOutPlayer().getId());
      outPlayerViewDto.setEndTime(new Date());
      outPlayerViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
      batsmanViewDao.update(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processRunOutAndNoBall(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getStriker().getId());;
    if (request.getBallDto().getBatsmanRuns() != null && request.getBallDto().getBatsmanRuns() > 0) {
      strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() + request.getBallDto().getBatsmanRuns());
    }
    if (request.getBallDto().getWicket().getOutPlayer().getId().equals(request.getBallDto().getStriker().getId())) {
      strikerBatsmanViewDto.setEndTime(new Date());
      strikerBatsmanViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
    } else {
      BatsmanViewDto outPlayerViewDto =
              batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getWicket().getOutPlayer().getId());
      outPlayerViewDto.setEndTime(new Date());
      outPlayerViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
      batsmanViewDao.update(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processObstructingTheFieldAndWide(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getStriker().getId());;
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    if (request.getBallDto().getBatsmanRuns() != null && request.getBallDto().getBatsmanRuns() > 0) {
      strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() + request.getBallDto().getBatsmanRuns());
    }
    if (request.getBallDto().getWicket().getOutPlayer().getId().equals(request.getBallDto().getStriker().getId())) {
      strikerBatsmanViewDto.setEndTime(new Date());
      strikerBatsmanViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
    } else {
      BatsmanViewDto outPlayerViewDto =
              batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getWicket().getOutPlayer().getId());
      outPlayerViewDto.setEndTime(new Date());
      outPlayerViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
      batsmanViewDao.update(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto processObstructingTheFieldAndNoBall(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getStriker().getId());;
    if (request.getBallDto().getBatsmanRuns() != null && request.getBallDto().getBatsmanRuns() > 0) {
      strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() + request.getBallDto().getBatsmanRuns());
    }
    if (request.getBallDto().getWicket().getOutPlayer().getId().equals(request.getBallDto().getStriker().getId())) {
      strikerBatsmanViewDto.setEndTime(new Date());
      strikerBatsmanViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
    } else {
      BatsmanViewDto outPlayerViewDto =
              batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(request.getBallDto().getInnings().getId(), request.getBallDto().getWicket().getOutPlayer().getId());
      outPlayerViewDto.setEndTime(new Date());
      outPlayerViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
      batsmanViewDao.update(outPlayerViewDto);
    }
    return batsmanViewDao.update(strikerBatsmanViewDto);
  }

  @Override
  public BatsmanViewDto unprocessNoBall(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessNoBallLegBye(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessNoBallBye(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessWideBall(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessWideBallBye(BatsmanViewUnprocessDto request) {
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
  public BatsmanViewDto unprocessRun(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessLegBye(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessBowled(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessCatch(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessCaughtAndBowled(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessStump(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessStumpAndWide(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessRunOut(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessRunOutAndWide(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessRunOutAndNoBall(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessWideTimedOutWicket(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessObstructingTheField(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessObstructingTheFieldAndWide(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessObstructingTheFieldAndNoBall(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessCaughtBehind(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessLegByWicket(BatsmanViewUnprocessDto request) {
    return null;
  }

  private BatsmanViewDto markPlayerAsNotOut(Long inningId, Long playerId)
      throws DugoutDataFetchingException {
    BatsmanViewDto outPlayerViewDto =
        batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(inningId, playerId);
    outPlayerViewDto.setEndTime(null);
    outPlayerViewDto.setStatus(BatsmanViewBatsmanStatus.PLAYING);
    return batsmanViewDao.update(outPlayerViewDto);
  }

  private BatsmanViewDto removeRunsFromPlayer(Long inningId, Long playerId, Integer runs)
      throws DugoutDataFetchingException {
    BatsmanViewDto strikerBatsmanViewDto = null;
    if (runs != null && runs > 0) {
      strikerBatsmanViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(inningId, playerId);
      strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() - runs);
      strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    }
    return strikerBatsmanViewDto;
  }
}
