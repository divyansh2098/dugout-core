package com.dugout.dugoutcore.service;

import com.dugout.dugoutcore.dao.BallDao;
import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BaseBallProcessRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BallProcessingService implements BaseBallService {
    private WicketService wicketService;
    private BallDao ballDao;

    @Override
    public BallDto processNoBall(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processNoBallLegBye(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processNoBallBye(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processWideBall(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processWideBallBye(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processFourRuns(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processSixRuns(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processLegBye(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processBold(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processCatch(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processCaughtAndBold(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processStump(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processStumpAndWide(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processRunOut(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processRunOutAndWide(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processRunOutAndNoBall(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processWideTimedOutWicket(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processObstructingTheField(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processObstructingTheFieldAndWide(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processObstructingTheFieldAndNoBall(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processCaughtBehind(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto processLegByWicket(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessNoBall(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessNoBallLegBye(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessNoBallBye(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessWideBall(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessWideBallBye(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessFourRuns(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessSixRuns(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessLegBye(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessBold(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessCatch(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessCaughtAndBold(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessStump(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessStumpAndWide(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessRunOut(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessRunOutAndWide(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessRunOutAndNoBall(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessWideTimedOutWicket(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessObstructingTheField(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessObstructingTheFieldAndWide(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessObstructingTheFieldAndNoBall(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessCaughtBehind(BaseBallProcessRequest request) {
        return null;
    }

    @Override
    public BallDto unprocessLegByWicket(BaseBallProcessRequest request) {
        return null;
    }
}
