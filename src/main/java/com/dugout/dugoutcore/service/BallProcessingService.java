package com.dugout.dugoutcore.service;

import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
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
      default -> null;
    };
  }
}
