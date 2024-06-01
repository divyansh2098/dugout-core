package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dto.*;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.BallProcessingService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InningViewProcessingServiceImpl
    implements BallProcessingService<InningsDto, InningViewProcessDto, InningViewUnprocessDto> {

  @NonNull private UserService userService;

  @Override
  public InningsDto processNoBall(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processNoBallLegBye(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processNoBallBye(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processWideBall(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processWideBallBye(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processFourRuns(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processSixRuns(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processRun(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processLegBye(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processWicket(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processStumpAndWide(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processRunOut(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processRunOutAndWide(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processRunOutAndNoBall(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processObstructingTheFieldAndWide(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto processObstructingTheFieldAndNoBall(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningsDto unprocessNoBall(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessNoBallLegBye(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessNoBallBye(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessWideBall(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessWideBallBye(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessFourRuns(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessSixRuns(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessRun(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessLegBye(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessBowled(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessCatch(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessCaughtAndBowled(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessStump(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessStumpAndWide(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessRunOut(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessRunOutAndWide(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessRunOutAndNoBall(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessObstructingTheField(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessObstructingTheFieldAndWide(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessObstructingTheFieldAndNoBall(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessCaughtBehind(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningsDto unprocessLegBeforeWicket(InningViewUnprocessDto request) {
    return null;
  }
}
