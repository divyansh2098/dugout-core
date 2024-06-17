package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.ApplicationConstants;
import com.dugout.dugoutcore.dao.BallDao;
import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.dto.BallUnprocessRequestDto;
import com.dugout.dugoutcore.dto.WicketDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.BallDtoConverter;
import com.dugout.dugoutcore.service.BallProcessingService;
import com.dugout.dugoutcore.service.WicketDtoConverter;
import com.dugout.dugoutcore.util.BallProcessingUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class BallProcessingServiceImpl
    implements BallProcessingService<BallDto, BallProcessRequestDto, BallUnprocessRequestDto> {
  @NonNull private WicketService wicketService;
  @NonNull private BallDao ballDao;
  @NonNull private BallDtoConverter ballDtoConverter;
  @NonNull private WicketDtoConverter wicketDtoConverter;
  @NonNull private BallProcessingUtils ballProcessingUtils;

  @NonNull private UserService userService;

  @Override
  public BallDto processNoBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setIsNextFreeHit(true);
    ballDto.setBatsmanRuns(request.getRuns());
    ballDto.setNextBallNumber(request.getBallNumber());
    ballDto.setRuns(1 + request.getRuns());
    ballDto.setIsOverComplete(false);
    ballDto.setIsValid(false);
    return ballDao.create(ballDto);
  }

  @Override
  public BallDto processNoBallLegBye(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setNextBallNumber(request.getBallNumber());
    ballDto.setRuns(1 + request.getRuns());
    ballDto.setBatsmanRuns(ApplicationConstants.ZERO_RUNS);
    ballDto.setIsNextFreeHit(true);
    ballDto.setIsOverComplete(false);
    ballDto.setIsValid(false);
    return ballDao.create(ballDto);
  }

  @Override
  public BallDto processNoBallBye(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setIsValid(false);
    ballDto.setBatsmanRuns(ApplicationConstants.ZERO_RUNS);
    ballDto.setNextBallNumber(request.getBallNumber());
    ballDto.setIsNextFreeHit(true);
    ballDto.setIsOverComplete(false);
    ballDto.setRuns(1 + request.getRuns());
    return ballDao.create(ballDto);
  }

  @Override
  public BallDto processWideBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setRuns(1 + request.getRuns());
    ballDto.setNextBallNumber(request.getBallNumber());
    ballDto.setIsValid(false);
    ballDto.setIsNextFreeHit(request.getIsFreeHit());
    ballDto.setIsOverComplete(false);
    ballDto.setBatsmanRuns(ApplicationConstants.ZERO_RUNS);
    return ballDao.create(ballDto);
  }

  @Override
  public BallDto processWideBallBye(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setRuns(1 + request.getRuns());
    ballDto.setNextBallNumber(request.getBallNumber());
    ballDto.setIsNextFreeHit(request.getIsFreeHit());
    ballDto.setIsValid(false);
    ballDto.setIsOverComplete(false);
    ballDto.setBatsmanRuns(ApplicationConstants.ZERO_RUNS);
    return ballDao.create(ballDto);
  }

  @Override
  public BallDto processFourRuns(BallProcessRequestDto request) throws DugoutDataFetchingException {
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setRuns(ApplicationConstants.FOUR_RUNS);
    ballDto.setNextBallNumber(request.getBallNumber() + 1);
    ballDto.setIsValid(true);
    ballDto.setBatsmanRuns(ApplicationConstants.FOUR_RUNS);
    ballDto.setBowlerRuns(ApplicationConstants.FOUR_RUNS);
    ballDto.setIsNextFreeHit(false);
    ballDto.setIsOverComplete(ballProcessingUtils.getIsOverComplete(request.getBallNumber()));
    return ballDao.create(ballDto);
  }

  @Override
  public BallDto processSixRuns(BallProcessRequestDto request) throws DugoutDataFetchingException {
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setBatsmanRuns(ApplicationConstants.SIX_RUNS);
    ballDto.setRuns(ApplicationConstants.SIX_RUNS);
    ballDto.setIsValid(true);
    ballDto.setIsNextFreeHit(false);
    ballDto.setIsOverComplete(ballProcessingUtils.getIsOverComplete(request.getBallNumber()));
    ballDto.setNextBallNumber(1 + request.getBallNumber());
    return ballDao.create(ballDto);
  }

  @Override
  public BallDto processRun(BallProcessRequestDto request) throws DugoutDataFetchingException {
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setBatsmanRuns(request.getRuns());
    ballDto.setRuns(request.getRuns());
    ballDto.setIsValid(true);
    ballDto.setIsNextFreeHit(false);
    ballDto.setIsOverComplete(ballProcessingUtils.getIsOverComplete(request.getBallNumber()));
    ballDto.setNextBallNumber(1 + request.getBallNumber());
    return ballDao.create(ballDto);
  }

  @Override
  public BallDto processLegBye(BallProcessRequestDto request) throws DugoutDataFetchingException {
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setBatsmanRuns(ApplicationConstants.ZERO_RUNS);
    ballDto.setRuns(request.getRuns());
    ballDto.setIsValid(true);
    ballDto.setIsNextFreeHit(false);
    ballDto.setIsOverComplete(ballProcessingUtils.getIsOverComplete(request.getBallNumber()));
    ballDto.setNextBallNumber(1 + request.getBallNumber());
    return ballDao.create(ballDto);
  }

  @Override
  public BallDto processWicket(BallProcessRequestDto request) throws DugoutDataFetchingException {
    WicketDto wicketDto =
        wicketDtoConverter.convertToWicketDto(request.getWicketMeta(), request.getInningId());
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setNextBallNumber(1 + request.getBallNumber());
    ballDto.setIsOverComplete(ballProcessingUtils.getIsOverComplete(request.getBallNumber()));
    ballDto.setRuns(ApplicationConstants.ZERO_RUNS);
    ballDto.setBatsmanRuns(ApplicationConstants.ZERO_RUNS);
    ballDto.setIsNextFreeHit(false);
    ballDto.setIsValid(true);
    BallDto createdBall = ballDao.create(ballDto);
    wicketDto.setBall(createdBall);
    WicketDto createdWicket = wicketService.create(wicketDto);
    createdBall.setWicket(createdWicket);
    return createdBall;
  }

  @Override
  public BallDto processStumpAndWide(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    WicketDto wicketDto =
        wicketDtoConverter.convertToWicketDto(request.getWicketMeta(), request.getInningId());
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setNextBallNumber(request.getBallNumber());
    ballDto.setIsOverComplete(false);
    ballDto.setRuns(ApplicationConstants.ONE_RUN);
    ballDto.setBatsmanRuns(ApplicationConstants.ZERO_RUNS);
    ballDto.setIsNextFreeHit(request.getIsFreeHit());
    ballDto.setIsValid(false);
    BallDto createdBall = ballDao.create(ballDto);
    wicketDto.setBall(createdBall);
    WicketDto createdWicket = wicketService.create(wicketDto);
    createdBall.setWicket(createdWicket);
    return createdBall;
  }

  @Override
  public BallDto processRunOut(BallProcessRequestDto request) throws DugoutDataFetchingException {
    WicketDto wicketDto =
        wicketDtoConverter.convertToWicketDto(request.getWicketMeta(), request.getInningId());
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setNextBallNumber(request.getBallNumber() + 1);
    ballDto.setIsOverComplete(ballProcessingUtils.getIsOverComplete(request.getBallNumber()));
    ballDto.setRuns(request.getRuns());
    ballDto.setBatsmanRuns(request.getRuns());
    ballDto.setIsNextFreeHit(request.getIsFreeHit());
    ballDto.setIsValid(false);
    BallDto createdBall = ballDao.create(ballDto);
    wicketDto.setBall(createdBall);
    WicketDto createdWicket = wicketService.create(wicketDto);
    createdBall.setWicket(createdWicket);
    return createdBall;
  }

  @Override
  public BallDto processRunOutAndWide(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    WicketDto wicketDto =
        wicketDtoConverter.convertToWicketDto(request.getWicketMeta(), request.getInningId());
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setNextBallNumber(request.getBallNumber());
    ballDto.setIsOverComplete(false);
    ballDto.setRuns(request.getRuns() + 1);
    ballDto.setBatsmanRuns(ApplicationConstants.ZERO_RUNS);
    ballDto.setIsNextFreeHit(request.getIsFreeHit());
    ballDto.setIsValid(false);
    BallDto createdBall = ballDao.create(ballDto);
    wicketDto.setBall(createdBall);
    WicketDto createdWicket = wicketService.create(wicketDto);
    createdBall.setWicket(createdWicket);
    return createdBall;
  }

  @Override
  public BallDto processRunOutAndNoBall(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    WicketDto wicketDto =
        wicketDtoConverter.convertToWicketDto(request.getWicketMeta(), request.getInningId());
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setIsNextFreeHit(true);
    ballDto.setIsOverComplete(false);
    ballDto.setIsValid(false);
    ballDto.setRuns(1 + request.getRuns());
    ballDto.setBatsmanRuns(request.getRuns()); // Think of a solution to determine this
    BallDto createdBall = ballDao.create(ballDto);
    wicketDto.setBall(createdBall);
    WicketDto createdWicket = wicketService.create(wicketDto);
    createdBall.setWicket(createdWicket);
    return createdBall;
  }

  @Override
  public BallDto processObstructingTheFieldAndWide(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    WicketDto wicketDto =
        wicketDtoConverter.convertToWicketDto(request.getWicketMeta(), request.getInningId());
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setNextBallNumber(request.getBallNumber());
    ballDto.setIsOverComplete(false);
    ballDto.setRuns(request.getRuns());
    ballDto.setBatsmanRuns(ApplicationConstants.ZERO_RUNS);
    ballDto.setIsNextFreeHit(request.getIsFreeHit());
    ballDto.setIsValid(false);
    BallDto createdBall = ballDao.create(ballDto);
    wicketDto.setBall(createdBall);
    WicketDto createdWicket = wicketService.create(wicketDto);
    createdBall.setWicket(createdWicket);
    return createdBall;
  }

  @Override
  public BallDto processObstructingTheFieldAndNoBall(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    WicketDto wicketDto =
        wicketDtoConverter.convertToWicketDto(request.getWicketMeta(), request.getInningId());
    BallDto ballDto = ballDtoConverter.convertBallRequestToBallDto(request);
    ballDto.setNextBallNumber(request.getBallNumber());
    ballDto.setIsOverComplete(false);
    ballDto.setRuns(request.getRuns() + 1);
    ballDto.setBatsmanRuns(request.getRuns());
    ballDto.setIsNextFreeHit(request.getIsFreeHit());
    ballDto.setIsValid(false);
    BallDto createdBall = ballDao.create(ballDto);
    wicketDto.setBall(createdBall);
    WicketDto createdWicket = wicketService.create(wicketDto);
    createdBall.setWicket(createdWicket);
    return createdBall;
  }

  @Override
  public BallDto unprocessNoBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessNoBallLegBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessNoBallBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessWideBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessWideBallBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessFourRuns(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessSixRuns(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessRun(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessLegBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessBowled(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessCatch(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessCaughtAndBowled(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessStump(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessStumpAndWide(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessRunOut(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessRunOutAndWide(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessRunOutAndNoBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessObstructingTheField(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessObstructingTheFieldAndWide(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessObstructingTheFieldAndNoBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessCaughtBehind(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BallDto unprocessLegBeforeWicket(BallUnprocessRequestDto request) {
    return null;
  }

  public BallDto unprocessBall(BallUnprocessRequestDto requestDto)
      throws DugoutDataFetchingException {
    BallDto existingBall = ballDao.getById(requestDto.getBallId());
    existingBall.setDeletedOn(new Date());
    existingBall.setDeletedBy(requestDto.getRequester());
    return ballDao.update(existingBall);
  }
}
