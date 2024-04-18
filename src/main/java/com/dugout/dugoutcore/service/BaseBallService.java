package com.dugout.dugoutcore.service;


import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BaseBallProcessRequest;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;

public interface BaseBallService {

    BallDto processNoBall(BaseBallProcessRequest request) throws DugoutDataFetchingException;
    BallDto processNoBallLegBye(BaseBallProcessRequest request);
    BallDto processNoBallBye(BaseBallProcessRequest request);
    BallDto processWideBall(BaseBallProcessRequest request);
    BallDto processWideBallBye(BaseBallProcessRequest request);
    BallDto processFourRuns(BaseBallProcessRequest request);
    BallDto processSixRuns(BaseBallProcessRequest request);
    BallDto processRun(BaseBallProcessRequest request);
    BallDto processLegBye(BaseBallProcessRequest request);
    BallDto processBold(BaseBallProcessRequest request);
    BallDto processCatch(BaseBallProcessRequest request);
    BallDto processCaughtAndBold(BaseBallProcessRequest request);
    BallDto processStump(BaseBallProcessRequest request);
    BallDto processStumpAndWide(BaseBallProcessRequest request);
    BallDto processRunOut(BaseBallProcessRequest request);
    BallDto processRunOutAndWide(BaseBallProcessRequest request);
    BallDto processRunOutAndNoBall(BaseBallProcessRequest request);
    BallDto processWideTimedOutWicket(BaseBallProcessRequest request);
    BallDto processObstructingTheField(BaseBallProcessRequest request);
    BallDto processObstructingTheFieldAndWide(BaseBallProcessRequest request);
    BallDto processObstructingTheFieldAndNoBall(BaseBallProcessRequest request);
    BallDto processCaughtBehind(BaseBallProcessRequest request);
    BallDto processLegByWicket(BaseBallProcessRequest request);


    BallDto unprocessNoBall(BaseBallProcessRequest request);
    BallDto unprocessNoBallLegBye(BaseBallProcessRequest request);
    BallDto unprocessNoBallBye(BaseBallProcessRequest request);
    BallDto unprocessWideBall(BaseBallProcessRequest request);
    BallDto unprocessWideBallBye(BaseBallProcessRequest request);
    BallDto unprocessFourRuns(BaseBallProcessRequest request);
    BallDto unprocessSixRuns(BaseBallProcessRequest request);
    BallDto unprocessRun(BaseBallProcessRequest request);
    BallDto unprocessLegBye(BaseBallProcessRequest request);
    BallDto unprocessBold(BaseBallProcessRequest request);
    BallDto unprocessCatch(BaseBallProcessRequest request);
    BallDto unprocessCaughtAndBold(BaseBallProcessRequest request);
    BallDto unprocessStump(BaseBallProcessRequest request);
    BallDto unprocessStumpAndWide(BaseBallProcessRequest request);
    BallDto unprocessRunOut(BaseBallProcessRequest request);
    BallDto unprocessRunOutAndWide(BaseBallProcessRequest request);
    BallDto unprocessRunOutAndNoBall(BaseBallProcessRequest request);
    BallDto unprocessWideTimedOutWicket(BaseBallProcessRequest request);
    BallDto unprocessObstructingTheField(BaseBallProcessRequest request);
    BallDto unprocessObstructingTheFieldAndWide(BaseBallProcessRequest request);
    BallDto unprocessObstructingTheFieldAndNoBall(BaseBallProcessRequest request);
    BallDto unprocessCaughtBehind(BaseBallProcessRequest request);
    BallDto unprocessLegByWicket(BaseBallProcessRequest request);
}
