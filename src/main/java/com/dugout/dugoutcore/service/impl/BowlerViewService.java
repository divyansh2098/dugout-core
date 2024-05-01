package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.dto.BallUnprocessRequestDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.BallProcessingService;
import org.springframework.stereotype.Service;

@Service
public class BowlerViewService implements BallProcessingService {
  @Override
  public BallDto processNoBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public BallDto processNoBallLegBye(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public BallDto processNoBallBye(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public BallDto processWideBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    return null;
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
  public BallDto processWicket(BallProcessRequestDto request) throws DugoutDataFetchingException {
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
  public BallDto unprocessWideTimedOutWicket(BallUnprocessRequestDto request) {
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
  public BallDto unprocessLegByWicket(BallUnprocessRequestDto request) {
    return null;
  }
}
