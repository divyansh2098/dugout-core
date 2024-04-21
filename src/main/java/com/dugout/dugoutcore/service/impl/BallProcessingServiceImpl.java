package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dao.BallDao;
import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.dto.WicketDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.pojo.enums.WicketType;
import com.dugout.dugoutcore.service.BallProcessingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BallProcessingServiceImpl implements BallProcessingService {
  private WicketService wicketService;
  private BallDao ballDao;
  private InningService inningService;
  private UserService userService;

  @Override
  public BallDto processNoBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    BallDto ballDto =
        BallDto.builder()
            .ballNumber(request.getBallNumber())
            .innings(inningService.getInningById(request.getInningId()))
            .striker(userService.getUser(request.getStrikerId()))
            .nonStriker(userService.getUser(request.getNonStrikerId()))
            .bowler(userService.getUser(request.getBowlerId()))
            .wicketKeeper(userService.getUser(request.getWicketkeeperId()))
            .isValid(false)
            .runs(1L + request.getRuns())
            .type(request.getBallType())
            .batsmanRuns(request.getRuns())
            .isFreeHit(request.getIsFreeHit())
            .isNextFreeHit(true)
            .nextBallNumber(request.getBallNumber())
            .comment(request.getComment())
            .build();
    return ballDao.create(ballDto);
  }

  @Override
  public BallDto processNoBallLegBye(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto =
        BallDto.builder()
            .nextBallNumber(request.getBallNumber())
            .runs(1L + request.getRuns())
            .batsmanRuns(0)
            .isValid(false)
            .ballNumber(request.getBallNumber())
            .type(request.getBallType())
            .bowler(userService.getUser(request.getBowlerId()))
            .striker(userService.getUser(request.getStrikerId()))
            .nonStriker(userService.getUser(request.getNonStrikerId()))
            .comment(request.getComment())
            .innings(inningService.getInningById(request.getInningId()))
            .isOverComplete(false)
            .isNextFreeHit(true)
            .nextBallNumber(request.getBallNumber())
            .wicketKeeper(userService.getUser(request.getWicketkeeperId()))
            .build();
    return ballDao.create(ballDto);
  }

  @Override
  public BallDto processNoBallBye(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto =
        BallDto.builder()
            .nextBallNumber(request.getBallNumber())
            .runs(1L + request.getRuns())
            .batsmanRuns(0)
            .isValid(false)
            .ballNumber(request.getBallNumber())
            .type(request.getBallType())
            .bowler(userService.getUser(request.getBowlerId()))
            .striker(userService.getUser(request.getStrikerId()))
            .nonStriker(userService.getUser(request.getNonStrikerId()))
            .comment(request.getComment())
            .innings(inningService.getInningById(request.getInningId()))
            .isOverComplete(false)
            .isNextFreeHit(true)
            .nextBallNumber(request.getBallNumber())
            .wicketKeeper(userService.getUser(request.getWicketkeeperId()))
            .build();
    return ballDao.create(ballDto);
  }

  @Override
  public BallDto processWideBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    BallDto ballDto =
        BallDto.builder()
            .nextBallNumber(request.getBallNumber())
            .runs(1L + request.getRuns())
            .isFreeHit(request.getIsFreeHit())
            .isNextFreeHit(request.getIsFreeHit())
            .striker(userService.getUser(request.getStrikerId()))
            .nonStriker(userService.getUser(request.getNonStrikerId()))
            .type(request.getBallType())
            .batsmanRuns(0)
            .bowler(userService.getUser(request.getBowlerId()))
            .innings(inningService.getInningById(request.getInningId()))
            .isOverComplete(false)
            .wicketKeeper(userService.getUser(request.getWicketkeeperId()))
            .isValid(false)
            .comment(request.getComment())
            .build();
    return ballDao.create(ballDto);
  }

  @Override
  public BallDto processWideBallBye(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processFourRuns(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processSixRuns(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processRun(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processLegBye(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processBowled(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processCatch(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processCaughtAndBowled(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processStump(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processStumpAndWide(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processRunOut(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processRunOutAndWide(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processRunOutAndNoBall(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    WicketDto wicketDto =
        WicketDto.builder()
            .outPlayer(userService.getUser(request.getWicketMeta().getOutPlayerId()))
            .type(WicketType.RUN_OUT_AND_NO_BALL)
            .innings(inningService.getInningById(request.getInningId()))
            .build();
    BallDto ballDto =
        BallDto.builder()
            .ballNumber(request.getBallNumber())
            .type(request.getBallType())
            .nextBallNumber(request.getBallNumber())
            .wicketKeeper(userService.getUser(request.getWicketkeeperId()))
            .isNextFreeHit(true)
            .isOverComplete(false)
            .innings(wicketDto.getInnings())
            .comment(request.getComment())
            .striker(userService.getUser(request.getStrikerId()))
            .nonStriker(userService.getUser(request.getNonStrikerId()))
            .bowler(userService.getUser(request.getBowlerId()))
            .isValid(false)
            .batsmanRuns(request.getRuns())
            .isFreeHit(request.getIsFreeHit())
            .build();
    BallDto createdBall = ballDao.create(ballDto);
    wicketDto.setBall(createdBall);
    WicketDto createdWicket = wicketService.create(wicketDto);
    createdBall.setWicket(createdWicket);
    return createdBall;
  }

  @Override
  public BallDto processWideTimedOutWicket(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processObstructingTheField(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processObstructingTheFieldAndWide(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processObstructingTheFieldAndNoBall(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processCaughtBehind(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto processLegByWicket(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessNoBall(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessNoBallLegBye(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessNoBallBye(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessWideBall(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessWideBallBye(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessFourRuns(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessSixRuns(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessRun(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessLegBye(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessBowled(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessCatch(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessCaughtAndBowled(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessStump(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessStumpAndWide(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessRunOut(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessRunOutAndWide(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessRunOutAndNoBall(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessWideTimedOutWicket(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessObstructingTheField(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessObstructingTheFieldAndWide(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessObstructingTheFieldAndNoBall(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessCaughtBehind(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessLegByWicket(BallProcessRequestDto request) {
    return null;
  }
}
