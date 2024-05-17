package com.dugout.dugoutcore.service;

import com.dugout.dugoutcore.dto.BallProcessRequest;
import com.dugout.dugoutcore.dto.BallUnprocessRequest;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;

public interface BallProcessingService<T, R extends BallProcessRequest, S extends BallUnprocessRequest> {

  T processNoBall(R request) throws DugoutDataFetchingException;

  T processNoBallLegBye(R request) throws DugoutDataFetchingException;

  T processNoBallBye(R request) throws DugoutDataFetchingException;

  T processWideBall(R request) throws DugoutDataFetchingException;

  T processWideBallBye(R request) throws DugoutDataFetchingException;

  T processFourRuns(R request) throws DugoutDataFetchingException;

  T processSixRuns(R request) throws DugoutDataFetchingException;

  T processRun(R request) throws DugoutDataFetchingException;

  T processLegBye(R request) throws DugoutDataFetchingException;

  T processWicket(R request) throws DugoutDataFetchingException;

  T processStumpAndWide(R request) throws DugoutDataFetchingException;

  T processRunOut(R request) throws DugoutDataFetchingException;

  T processRunOutAndWide(R request) throws DugoutDataFetchingException;

  T processRunOutAndNoBall(R request) throws DugoutDataFetchingException;

  T processObstructingTheFieldAndWide(R request)
      throws DugoutDataFetchingException;

  T processObstructingTheFieldAndNoBall(R request)
      throws DugoutDataFetchingException;

  T unprocessNoBall(S request);

  T unprocessNoBallLegBye(S request);

  T unprocessNoBallBye(S request);

  T unprocessWideBall(S request);

  T unprocessWideBallBye(S request);

  T unprocessFourRuns(S request);

  T unprocessSixRuns(S request);

  T unprocessRun(S request);

  T unprocessLegBye(S request);

  T unprocessBowled(S request);

  T unprocessCatch(S request);

  T unprocessCaughtAndBowled(S request);

  T unprocessStump(S request);

  T unprocessStumpAndWide(S request);

  T unprocessRunOut(S request);

  T unprocessRunOutAndWide(S request);

  T unprocessRunOutAndNoBall(S request);

  T unprocessWideTimedOutWicket(S request);

  T unprocessObstructingTheField(S request);

  T unprocessObstructingTheFieldAndWide(S request);

  T unprocessObstructingTheFieldAndNoBall(S request);

  T unprocessCaughtBehind(S request);

  T unprocessLegByWicket(S request);

  /**
   * @param {BaseBallProcessRequest} request record Ball request
   * @return {BallDto} ballDto recorded ball data
   * @throws DugoutDataFetchingException Add cases here for each ball type calling the relevant
   *     handler function here
   */
  default T processBall(R request) throws DugoutDataFetchingException {
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

  default T unprocessBall(S requestDto)
      throws DugoutDataFetchingException {
    return switch (requestDto.getBallType()) {
      case NO_BALL -> unprocessNoBall(requestDto);
      default -> null;
    };
  }
}
