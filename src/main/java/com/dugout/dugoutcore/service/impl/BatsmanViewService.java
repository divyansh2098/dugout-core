package com.dugout.dugoutcore.service.impl;

import static com.dugout.dugoutcore.ApplicationConstants.FOUR_RUNS;
import static com.dugout.dugoutcore.ApplicationConstants.SIX_RUNS;

import com.dugout.dugoutcore.dao.BatsmanViewDao;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.dto.BallUnprocessRequestDto;
import com.dugout.dugoutcore.dto.BatsmanViewDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.pojo.enums.BatsmanViewBatsmanStatus;
import com.dugout.dugoutcore.service.BallProcessingService;
import com.dugout.dugoutcore.util.BallProcessingUtils;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class BatsmanViewService implements BallProcessingService<BatsmanViewDto> {
  private BatsmanViewDao batsmanViewDao;
  private UserService userService;
  private BallProcessingUtils ballProcessingUtils;

  @Override
  public BatsmanViewDto processNoBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // Batsmen view will only change if there are some runs from batsmen
    return addRunsToPlayer(request.getInningId(), request.getStrikerId(), request.getRuns());
  }

  @Override
  public BatsmanViewDto processNoBallLegBye(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    // nothing will be done here
    return null;
  }

  @Override
  public BatsmanViewDto processNoBallBye(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    // nothing will be done here
    return null;
  }

  @Override
  public BatsmanViewDto processWideBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // nothing will be done here
    return null;
  }

  @Override
  public BatsmanViewDto processWideBallBye(BallProcessRequestDto request) {
    // nothing will be done here
    return null;
  }

  @Override
  public BatsmanViewDto processFourRuns(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // adds 4 runs to the striker runs
    return addRunsToPlayer(request.getInningId(), request.getStrikerId(), FOUR_RUNS);
  }

  @Override
  public BatsmanViewDto processSixRuns(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // adds 6 runs to the striker runs
    return addRunsToPlayer(request.getInningId(), request.getStrikerId(), SIX_RUNS);
  }

  @Override
  public BatsmanViewDto processRun(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // adds given runs to the striker runs
    return addRunsToPlayer(request.getInningId(), request.getStrikerId(), request.getRuns());
  }

  @Override
  public BatsmanViewDto processLegBye(BallProcessRequestDto request) {
    // nothing will be done here
    return null;
  }

  @Override
  public BatsmanViewDto processWicket(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // marking given player as out and add runs to striker if any
    BatsmanViewDto outPlayerViewDto = markPlayerAsOut(request.getInningId(), request.getWicketMeta().getOutPlayerId());
    addRunsToPlayer(request.getInningId(), request.getStrikerId(), request.getRuns());
    return outPlayerViewDto;
  }

  @Override
  public BatsmanViewDto processStumpAndWide(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // marking given player as out
    return markPlayerAsOut(request.getInningId(), request.getWicketMeta().getOutPlayerId());
  }

  @Override
  public BatsmanViewDto processRunOut(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    BatsmanViewDto outPlayerViewDto = markPlayerAsOut(request.getInningId(), request.getWicketMeta().getOutPlayerId());
    addRunsToPlayer(request.getInningId(), request.getStrikerId(), request.getRuns());
    return outPlayerViewDto;
  }

  @Override
  public BatsmanViewDto processRunOutAndWide(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    BatsmanViewDto outPlayerViewDto = markPlayerAsOut(request.getInningId(), request.getWicketMeta().getOutPlayerId());
    addRunsToPlayer(request.getInningId(), request.getStrikerId(), request.getRuns());
    return outPlayerViewDto;
  }

  @Override
  public BatsmanViewDto processRunOutAndNoBall(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    BatsmanViewDto outPlayerViewDto = markPlayerAsOut(request.getInningId(), request.getWicketMeta().getOutPlayerId());
    addRunsToPlayer(request.getInningId(), request.getStrikerId(), request.getRuns());
    return outPlayerViewDto;
  }

  @Override
  public BatsmanViewDto processObstructingTheFieldAndWide(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    BatsmanViewDto outPlayerViewDto = markPlayerAsOut(request.getInningId(), request.getWicketMeta().getOutPlayerId());
    addRunsToPlayer(request.getInningId(), request.getStrikerId(), request.getRuns());
    return outPlayerViewDto;
  }

  @Override
  public BatsmanViewDto processObstructingTheFieldAndNoBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    BatsmanViewDto outPlayerViewDto = markPlayerAsOut(request.getInningId(), request.getWicketMeta().getOutPlayerId());
    addRunsToPlayer(request.getInningId(), request.getStrikerId(), request.getRuns());
    return outPlayerViewDto;
  }

  @Override
  public BatsmanViewDto unprocessNoBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessNoBallLegBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessNoBallBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessWideBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessWideBallBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessFourRuns(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessSixRuns(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessRun(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessLegBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessBowled(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessCatch(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessCaughtAndBowled(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessStump(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessStumpAndWide(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessRunOut(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessRunOutAndWide(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessRunOutAndNoBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessWideTimedOutWicket(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessObstructingTheField(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessObstructingTheFieldAndWide(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessObstructingTheFieldAndNoBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessCaughtBehind(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BatsmanViewDto unprocessLegByWicket(BallUnprocessRequestDto request) {
    return null;
  }

  private BatsmanViewDto markPlayerAsOut(Long inningId, Long playerId) throws DugoutDataFetchingException {
    BatsmanViewDto outPlayerViewDto = batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            inningId, playerId);
    outPlayerViewDto.setEndTime(new Date());
    outPlayerViewDto.setStatus(BatsmanViewBatsmanStatus.OUT);
    return batsmanViewDao.update(outPlayerViewDto);
  }

  private BatsmanViewDto addRunsToPlayer(Long inningId, Long playerId, Integer runs) throws DugoutDataFetchingException {
    BatsmanViewDto strikerBatsmanViewDto = null;
    if (runs != null && runs > 0) {
      strikerBatsmanViewDto =  batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              inningId, playerId);
      strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() + runs);
      strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    }
    return strikerBatsmanViewDto;
  }

  private BatsmanViewDto markPlayerAsNotOut(Long inningId, Long playerId) throws DugoutDataFetchingException {
    BatsmanViewDto outPlayerViewDto = batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
            inningId, playerId);
    outPlayerViewDto.setEndTime(null);
    outPlayerViewDto.setStatus(BatsmanViewBatsmanStatus.PLAYING);
    return batsmanViewDao.update(outPlayerViewDto);
  }

  private BatsmanViewDto removeRunsFromPlayer(Long inningId, Long playerId, Integer runs) throws DugoutDataFetchingException {
    BatsmanViewDto strikerBatsmanViewDto = null;
    if (runs != null && runs > 0) {
      strikerBatsmanViewDto =  batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              inningId, playerId);
      strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() - runs);
      strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    }
    return strikerBatsmanViewDto;
  }
}
