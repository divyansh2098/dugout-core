package com.dugout.dugoutcore.service;

import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.dto.BallUnprocessRequestDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;

public interface BallProcessingService {

  BallDto processNoBall(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processNoBallLegBye(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processNoBallBye(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processWideBall(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processWideBallBye(BallProcessRequestDto request);

  BallDto processFourRuns(BallProcessRequestDto request);

  BallDto processSixRuns(BallProcessRequestDto request);

  BallDto processRun(BallProcessRequestDto request);

  BallDto processLegBye(BallProcessRequestDto request);

  BallDto processBowled(BallProcessRequestDto request);

  BallDto processCatch(BallProcessRequestDto request);

  BallDto processCaughtAndBowled(BallProcessRequestDto request);

  BallDto processStump(BallProcessRequestDto request);

  BallDto processStumpAndWide(BallProcessRequestDto request);

  BallDto processRunOut(BallProcessRequestDto request);

  BallDto processRunOutAndWide(BallProcessRequestDto request);

  BallDto processRunOutAndNoBall(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processWideTimedOutWicket(BallProcessRequestDto request);

  BallDto processObstructingTheField(BallProcessRequestDto request);

  BallDto processObstructingTheFieldAndWide(BallProcessRequestDto request);

  BallDto processObstructingTheFieldAndNoBall(BallProcessRequestDto request);

  BallDto processCaughtBehind(BallProcessRequestDto request);

  BallDto processLegByWicket(BallProcessRequestDto request);

  BallDto unprocessNoBall(BallUnprocessRequestDto request);

  BallDto unprocessNoBallLegBye(BallUnprocessRequestDto request);

  BallDto unprocessNoBallBye(BallUnprocessRequestDto request);

  BallDto unprocessWideBall(BallUnprocessRequestDto request);

  BallDto unprocessWideBallBye(BallUnprocessRequestDto request);

  BallDto unprocessFourRuns(BallUnprocessRequestDto request);

  BallDto unprocessSixRuns(BallUnprocessRequestDto request);

  BallDto unprocessRun(BallUnprocessRequestDto request);

  BallDto unprocessLegBye(BallUnprocessRequestDto request);

  BallDto unprocessBowled(BallUnprocessRequestDto request);

  BallDto unprocessCatch(BallUnprocessRequestDto request);

  BallDto unprocessCaughtAndBowled(BallUnprocessRequestDto request);

  BallDto unprocessStump(BallUnprocessRequestDto request);

  BallDto unprocessStumpAndWide(BallUnprocessRequestDto request);

  BallDto unprocessRunOut(BallUnprocessRequestDto request);

  BallDto unprocessRunOutAndWide(BallUnprocessRequestDto request);

  BallDto unprocessRunOutAndNoBall(BallUnprocessRequestDto request);

  BallDto unprocessWideTimedOutWicket(BallUnprocessRequestDto request);

  BallDto unprocessObstructingTheField(BallUnprocessRequestDto request);

  BallDto unprocessObstructingTheFieldAndWide(BallUnprocessRequestDto request);

  BallDto unprocessObstructingTheFieldAndNoBall(BallUnprocessRequestDto request);

  BallDto unprocessCaughtBehind(BallUnprocessRequestDto request);

  BallDto unprocessLegByWicket(BallUnprocessRequestDto request);

  /**
   * @param {BaseBallProcessRequest} request record Ball request
   * @return {BallDto} ballDto recorded ball data
   * @throws DugoutDataFetchingException Add cases here for each ball type calling the relevant
   *     handler function here
   */
  default BallDto processBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    return switch (request.getBallType()) {
      case NO_BALL -> processNoBall(request);
      case NO_BALL_BYE -> processNoBallBye(request);
      case NO_BALL_LEG_BYE -> processNoBallLegBye(request);
      case NO_BALL_RUN_OUT -> processRunOutAndNoBall(request);
      case WIDE -> processWideBall(request);
      default -> null;
    };
  }

  default BallDto unprocessBall(BallUnprocessRequestDto requestDto)
      throws DugoutDataFetchingException {
    return switch (requestDto.getBallType()) {
      case NO_BALL -> unprocessNoBall(requestDto);
      default -> null;
    };
  }
}
