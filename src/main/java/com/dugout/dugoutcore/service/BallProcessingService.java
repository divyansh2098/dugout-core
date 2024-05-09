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

  BallDto processWideBallBye(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processFourRuns(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processSixRuns(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processRun(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processLegBye(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processWicket(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processStumpAndWide(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processRunOut(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processRunOutAndWide(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processRunOutAndNoBall(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processObstructingTheFieldAndWide(BallProcessRequestDto request)
      throws DugoutDataFetchingException;

  BallDto processObstructingTheFieldAndNoBall(BallProcessRequestDto request)
      throws DugoutDataFetchingException;

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
      case WIDE_BYE -> processWideBallBye(request);
      case FOUR -> processFourRuns(request);
      case SIX -> processSixRuns(request);
      case RUN -> processRun(request);
      case LEG_BYE -> processLegBye(request);
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
