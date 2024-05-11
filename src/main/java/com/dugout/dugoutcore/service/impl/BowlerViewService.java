package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.dto.BallUnprocessRequestDto;
import com.dugout.dugoutcore.dto.BowlerViewDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.BallProcessingService;
import org.springframework.stereotype.Service;

@Service
public class BowlerViewService implements BallProcessingService<BowlerViewDto> {
  @Override
  public BowlerViewDto processNoBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public BowlerViewDto processNoBallLegBye(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public BowlerViewDto processNoBallBye(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public BowlerViewDto processWideBall(BallProcessRequestDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public BowlerViewDto processWideBallBye(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto processFourRuns(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto processSixRuns(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto processRun(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto processLegBye(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto processWicket(BallProcessRequestDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public BowlerViewDto processStumpAndWide(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto processRunOut(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto processRunOutAndWide(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto processRunOutAndNoBall(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public BowlerViewDto processObstructingTheFieldAndWide(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto processObstructingTheFieldAndNoBall(BallProcessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessNoBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessNoBallLegBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessNoBallBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessWideBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessWideBallBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessFourRuns(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessSixRuns(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessRun(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessLegBye(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessBowled(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessCatch(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessCaughtAndBowled(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessStump(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessStumpAndWide(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessRunOut(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessRunOutAndWide(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessRunOutAndNoBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessWideTimedOutWicket(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessObstructingTheField(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessObstructingTheFieldAndWide(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessObstructingTheFieldAndNoBall(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessCaughtBehind(BallUnprocessRequestDto request) {
    return null;
  }

  @Override
  public BowlerViewDto unprocessLegByWicket(BallUnprocessRequestDto request) {
    return null;
  }
}
