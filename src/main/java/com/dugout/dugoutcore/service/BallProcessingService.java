package com.dugout.dugoutcore.service;

import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
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

  BallDto processObstructingTheFieldAndWide(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto processObstructingTheFieldAndNoBall(BallProcessRequestDto request) throws DugoutDataFetchingException;

  BallDto unprocessNoBall(BallProcessRequestDto request);

  BallDto unprocessNoBallLegBye(BallProcessRequestDto request);

  BallDto unprocessNoBallBye(BallProcessRequestDto request);

  BallDto unprocessWideBall(BallProcessRequestDto request);

  BallDto unprocessWideBallBye(BallProcessRequestDto request);

  BallDto unprocessFourRuns(BallProcessRequestDto request);

  BallDto unprocessSixRuns(BallProcessRequestDto request);

  BallDto unprocessRun(BallProcessRequestDto request);

  BallDto unprocessLegBye(BallProcessRequestDto request);

  BallDto unprocessBowled(BallProcessRequestDto request);

  BallDto unprocessCatch(BallProcessRequestDto request);

  BallDto unprocessCaughtAndBowled(BallProcessRequestDto request);

  BallDto unprocessStump(BallProcessRequestDto request);

  BallDto unprocessStumpAndWide(BallProcessRequestDto request);

  BallDto unprocessRunOut(BallProcessRequestDto request);

  BallDto unprocessRunOutAndWide(BallProcessRequestDto request);

  BallDto unprocessRunOutAndNoBall(BallProcessRequestDto request);

  BallDto unprocessWideTimedOutWicket(BallProcessRequestDto request);

  BallDto unprocessObstructingTheField(BallProcessRequestDto request);

  BallDto unprocessObstructingTheFieldAndWide(BallProcessRequestDto request);

  BallDto unprocessObstructingTheFieldAndNoBall(BallProcessRequestDto request);

  BallDto unprocessCaughtBehind(BallProcessRequestDto request);

  BallDto unprocessLegByWicket(BallProcessRequestDto request);

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
}
