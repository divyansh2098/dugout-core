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
    implements BallProcessingService<InningDto, InningViewProcessDto, InningViewUnprocessDto> {

  @NonNull private UserService userService;

  @Override
  public InningDto processNoBall(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processNoBallLegBye(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processNoBallBye(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processWideBall(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processWideBallBye(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processFourRuns(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processSixRuns(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processRun(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processLegBye(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processWicket(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processStumpAndWide(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processRunOut(InningViewProcessDto request) throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processRunOutAndWide(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processRunOutAndNoBall(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processObstructingTheFieldAndWide(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto processObstructingTheFieldAndNoBall(InningViewProcessDto request)
      throws DugoutDataFetchingException {
    return null;
  }

  @Override
  public InningDto unprocessNoBall(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessNoBallLegBye(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessNoBallBye(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessWideBall(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessWideBallBye(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessFourRuns(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessSixRuns(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessRun(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessLegBye(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessBowled(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessCatch(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessCaughtAndBowled(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessStump(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessStumpAndWide(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessRunOut(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessRunOutAndWide(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessRunOutAndNoBall(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessObstructingTheField(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessObstructingTheFieldAndWide(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessObstructingTheFieldAndNoBall(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessCaughtBehind(InningViewUnprocessDto request) {
    return null;
  }

  @Override
  public InningDto unprocessLegBeforeWicket(InningViewUnprocessDto request) {
    return null;
  }
}
