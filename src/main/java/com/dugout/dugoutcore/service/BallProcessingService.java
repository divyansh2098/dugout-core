package com.dugout.dugoutcore.service;

import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.dto.BallUnprocessRequestDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;

public interface BallProcessingService<T> {

  T processNoBall(BallProcessRequestDto request) throws DugoutDataFetchingException;

  T processNoBallLegBye(BallProcessRequestDto request) throws DugoutDataFetchingException;

  T processNoBallBye(BallProcessRequestDto request) throws DugoutDataFetchingException;

  T processWideBall(BallProcessRequestDto request) throws DugoutDataFetchingException;

  T processWideBallBye(BallProcessRequestDto request) throws DugoutDataFetchingException;

  T processFourRuns(BallProcessRequestDto request) throws DugoutDataFetchingException;

  T processSixRuns(BallProcessRequestDto request) throws DugoutDataFetchingException;

  T processRun(BallProcessRequestDto request) throws DugoutDataFetchingException;

  T processLegBye(BallProcessRequestDto request) throws DugoutDataFetchingException;

  T processWicket(BallProcessRequestDto request) throws DugoutDataFetchingException;

  T processStumpAndWide(BallProcessRequestDto request) throws DugoutDataFetchingException;

  T processRunOut(BallProcessRequestDto request) throws DugoutDataFetchingException;

  T processRunOutAndWide(BallProcessRequestDto request) throws DugoutDataFetchingException;

  T processRunOutAndNoBall(BallProcessRequestDto request) throws DugoutDataFetchingException;

  T processObstructingTheFieldAndWide(BallProcessRequestDto request)
      throws DugoutDataFetchingException;

  T processObstructingTheFieldAndNoBall(BallProcessRequestDto request)
      throws DugoutDataFetchingException;

  T unprocessNoBall(BallUnprocessRequestDto request);

  T unprocessNoBallLegBye(BallUnprocessRequestDto request);

  T unprocessNoBallBye(BallUnprocessRequestDto request);

  T unprocessWideBall(BallUnprocessRequestDto request);

  T unprocessWideBallBye(BallUnprocessRequestDto request);

  T unprocessFourRuns(BallUnprocessRequestDto request);

  T unprocessSixRuns(BallUnprocessRequestDto request);

  T unprocessRun(BallUnprocessRequestDto request);

  T unprocessLegBye(BallUnprocessRequestDto request);

  T unprocessBowled(BallUnprocessRequestDto request);

  T unprocessCatch(BallUnprocessRequestDto request);

  T unprocessCaughtAndBowled(BallUnprocessRequestDto request);

  T unprocessStump(BallUnprocessRequestDto request);

  T unprocessStumpAndWide(BallUnprocessRequestDto request);

  T unprocessRunOut(BallUnprocessRequestDto request);

  T unprocessRunOutAndWide(BallUnprocessRequestDto request);

  T unprocessRunOutAndNoBall(BallUnprocessRequestDto request);

  T unprocessWideTimedOutWicket(BallUnprocessRequestDto request);

  T unprocessObstructingTheField(BallUnprocessRequestDto request);

  T unprocessObstructingTheFieldAndWide(BallUnprocessRequestDto request);

  T unprocessObstructingTheFieldAndNoBall(BallUnprocessRequestDto request);

  T unprocessCaughtBehind(BallUnprocessRequestDto request);

  T unprocessLegByWicket(BallUnprocessRequestDto request);

  /**
   * @param {BaseBallProcessRequest} request record Ball request
   * @return {BallDto} ballDto recorded ball data
   * @throws DugoutDataFetchingException Add cases here for each ball type calling the relevant
   *     handler function here
   */
  default T processBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
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

  default T unprocessBall(BallUnprocessRequestDto requestDto)
      throws DugoutDataFetchingException {
    return switch (requestDto.getBallType()) {
      case NO_BALL -> unprocessNoBall(requestDto);
      default -> null;
    };
  }
}
