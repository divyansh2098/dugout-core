package com.dugout.dugoutcore.service.impl.views;

import static com.dugout.dugoutcore.ApplicationConstants.FOUR_RUNS;
import static com.dugout.dugoutcore.ApplicationConstants.SIX_RUNS;

import com.dugout.dugoutcore.dao.BatsmanViewDao;
import com.dugout.dugoutcore.dto.*;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.BallProcessingService;
import com.dugout.dugoutcore.service.impl.UserService;
import com.dugout.dugoutcore.util.BallProcessingUtils;
import com.dugout.dugoutcore.util.BatsmanViewUtils;

import java.util.List;
import java.util.Objects;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BatsmanViewServiceImpl
    implements BallProcessingService<
        BatsmanViewResponseDto, BatsmanViewProcessDto, BatsmanViewUnprocessDto> {
  @NonNull private BatsmanViewDao batsmanViewDao;
  @NonNull private UserService userService;
  @NonNull private BallProcessingUtils ballProcessingUtils;

  @NonNull private BatsmanViewUtils batsmanViewUtils;

  @Override
  public BatsmanViewResponseDto processNoBall(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // Batsmen view will only change if there are some runs from batsmen
    List<BatsmanViewDto> batsmanViewDtoList = null;
    BatsmanViewDto strikerBatsmanViewDto = null;
    if (request.getBallDto().getBatsmanRuns() != null && request.getBallDto().getBatsmanRuns() > 0) {
      batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
      strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
      batsmanViewUtils.increaseBatsmanRuns(strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
      batsmanViewUtils.incrementBallsFaced(strikerBatsmanViewDto);
      strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
      batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    }
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto processNoBallLegBye(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, ballDto.getStriker().getId());
    batsmanViewUtils.incrementBallsFaced(strikerBatsmanViewDto);
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto processNoBallBye(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, ballDto.getStriker().getId());
    batsmanViewUtils.incrementBallsFaced(strikerBatsmanViewDto);
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto processWideBall(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // nothing will be done here
    return null;
  }

  @Override
  public BatsmanViewResponseDto processFourRuns(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // adds 4 runs to the striker runs and increment num ball
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    batsmanViewUtils.increaseBatsmanRuns(strikerBatsmanViewDto, FOUR_RUNS);
    batsmanViewUtils.incrementBallsFaced(strikerBatsmanViewDto);
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto processSixRuns(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // adds 6 runs to the striker runs and increment num ball
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() + SIX_RUNS);
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto processRun(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // adds given runs to the striker runs and increment num ball
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() + request.getBallDto().getBatsmanRuns());
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto processLegBye(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // nothing will be done here except increasing the num balls
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    batsmanViewUtils.incrementBallsFaced(strikerBatsmanViewDto);
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto processWicket(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and add runs to striker if any and increment num balls for
    // striker
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());

    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    if (request.getBallDto().getBatsmanRuns() != null
        && request.getBallDto().getBatsmanRuns() > 0) {
      batsmanViewUtils.increaseBatsmanRuns(
          strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
    }
    if (request
        .getBallDto()
        .getWicket()
        .getOutPlayer()
        .getId()
        .equals(request.getBallDto().getStriker().getId())) {
      batsmanViewUtils.markBatsmanOut(strikerBatsmanViewDto, request.getBallDto().getWicket());
    } else {
      BatsmanViewDto outPlayerViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
      outPlayerViewDto = batsmanViewDao.update(outPlayerViewDto);
      batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, outPlayerViewDto);
    }
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto processStumpAndWide(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto outPlayerViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getWicket().getOutPlayer().getId());
    batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
    outPlayerViewDto = batsmanViewDao.update(outPlayerViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, outPlayerViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto processRunOut(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any and incrementing num balls
    // for striker
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());

    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    if (request.getBallDto().getBatsmanRuns() != null
        && request.getBallDto().getBatsmanRuns() > 0) {
      batsmanViewUtils.increaseBatsmanRuns(
          strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
    }
    if (request
        .getBallDto()
        .getWicket()
        .getOutPlayer()
        .getId()
        .equals(request.getBallDto().getStriker().getId())) {
      batsmanViewUtils.markBatsmanOut(strikerBatsmanViewDto, request.getBallDto().getWicket());
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              request.getBallDto().getInning().getId(),
              request.getBallDto().getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
      outPlayerViewDto = batsmanViewDao.update(outPlayerViewDto);
      batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, outPlayerViewDto);
    }
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto processRunOutAndWide(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    if (request
        .getBallDto()
        .getWicket()
        .getOutPlayer()
        .getId()
        .equals(request.getBallDto().getStriker().getId())) {
      batsmanViewUtils.markBatsmanOut(strikerBatsmanViewDto, request.getBallDto().getWicket());
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              request.getBallDto().getInning().getId(),
              request.getBallDto().getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
      outPlayerViewDto = batsmanViewDao.update(outPlayerViewDto);
      batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, outPlayerViewDto);
    }
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto processRunOutAndNoBall(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    if (request.getBallDto().getBatsmanRuns() != null
        && request.getBallDto().getBatsmanRuns() > 0) {
      batsmanViewUtils.increaseBatsmanRuns(
          strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
    }
    if (request
        .getBallDto()
        .getWicket()
        .getOutPlayer()
        .getId()
        .equals(request.getBallDto().getStriker().getId())) {
      batsmanViewUtils.markBatsmanOut(strikerBatsmanViewDto, request.getBallDto().getWicket());
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              request.getBallDto().getInning().getId(),
              request.getBallDto().getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
      outPlayerViewDto = batsmanViewDao.update(outPlayerViewDto);
      batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, outPlayerViewDto);
    }
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto processObstructingTheField(BatsmanViewProcessDto request) throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    if (request.getBallDto().getBatsmanRuns() != null
            && request.getBallDto().getBatsmanRuns() > 0) {
      batsmanViewUtils.increaseBatsmanRuns(
              strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
    }
    if (request
            .getBallDto()
            .getWicket()
            .getOutPlayer()
            .getId()
            .equals(request.getBallDto().getStriker().getId())) {
      batsmanViewUtils.markBatsmanOut(strikerBatsmanViewDto, request.getBallDto().getWicket());
    } else {
      BatsmanViewDto outPlayerViewDto =
              batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
                      request.getBallDto().getInning().getId(),
                      request.getBallDto().getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
      outPlayerViewDto = batsmanViewDao.update(outPlayerViewDto);
      batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, outPlayerViewDto);
    }
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto processObstructingTheFieldAndWide(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() + 1);
    if (request.getBallDto().getBatsmanRuns() != null
        && request.getBallDto().getBatsmanRuns() > 0) {
      batsmanViewUtils.increaseBatsmanRuns(
          strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
    }
    if (request
        .getBallDto()
        .getWicket()
        .getOutPlayer()
        .getId()
        .equals(request.getBallDto().getStriker().getId())) {
      batsmanViewUtils.markBatsmanOut(strikerBatsmanViewDto, request.getBallDto().getWicket());
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              request.getBallDto().getInning().getId(),
              request.getBallDto().getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
      outPlayerViewDto = batsmanViewDao.update(outPlayerViewDto);
      batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, outPlayerViewDto);
    }
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto processObstructingTheFieldAndNoBall(BatsmanViewProcessDto request)
      throws DugoutDataFetchingException {
    // marking given player as out and adding runs to striker view if any
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    if (request.getBallDto().getBatsmanRuns() != null
        && request.getBallDto().getBatsmanRuns() > 0) {
      batsmanViewUtils.increaseBatsmanRuns(
          strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
    }
    if (request
        .getBallDto()
        .getWicket()
        .getOutPlayer()
        .getId()
        .equals(request.getBallDto().getStriker().getId())) {
      batsmanViewUtils.markBatsmanOut(strikerBatsmanViewDto, request.getBallDto().getWicket());
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              request.getBallDto().getInning().getId(),
              request.getBallDto().getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanOut(outPlayerViewDto, request.getBallDto().getWicket());
      outPlayerViewDto = batsmanViewDao.update(outPlayerViewDto);
      batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, outPlayerViewDto);
    }
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto unprocessNoBall(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, ballDto.getStriker().getId());
    strikerBatsmanViewDto.setNumBalls(strikerBatsmanViewDto.getNumBalls() - 1);
    strikerBatsmanViewDto.setRuns(strikerBatsmanViewDto.getRuns() - ballDto.getBatsmanRuns());
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto unprocessNoBallLegBye(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    batsmanViewUtils.decrementBallsFaced(strikerBatsmanViewDto);
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto unprocessNoBallBye(BatsmanViewUnprocessDto request) {
    // Nothing to be updated here
    return null;
  }

  @Override
  public BatsmanViewResponseDto unprocessWideBall(BatsmanViewUnprocessDto request) {
    // Nothing to be done here
    return null;
  }

  @Override
  public BatsmanViewResponseDto unprocessWideBallBye(BatsmanViewUnprocessDto request) {
    // nothing to be done here
    return null;
  }

  @Override
  public BatsmanViewResponseDto unprocessFourRuns(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewResponseDto unprocessSixRuns(BatsmanViewUnprocessDto request) {
    return null;
  }

  @Override
  public BatsmanViewResponseDto unprocessRun(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    batsmanViewUtils.decreaseBatsmanRuns(
        strikerBatsmanViewDto, request.getBallDto().getBatsmanRuns());
    batsmanViewUtils.decrementBallsFaced(strikerBatsmanViewDto);
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto unprocessLegBye(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    batsmanViewUtils.decrementBallsFaced(strikerBatsmanViewDto);
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto unprocessBowled(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    batsmanViewUtils.decrementBallsFaced(strikerBatsmanViewDto);
    batsmanViewUtils.markBatsmanAsNotOut(strikerBatsmanViewDto);
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto unprocessCatch(BatsmanViewUnprocessDto request) {
    // Not used
    return null;
  }

  @Override
  public BatsmanViewResponseDto unprocessCaughtAndBowled(BatsmanViewUnprocessDto request) {
    // Not used
    return null;
  }

  @Override
  public BatsmanViewResponseDto unprocessStump(BatsmanViewUnprocessDto request) {
    // Not used
    return null;
  }

  @Override
  public BatsmanViewResponseDto unprocessStumpAndWide(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    batsmanViewUtils.markBatsmanAsNotOut(strikerBatsmanViewDto);
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto unprocessRunOut(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, ballDto.getStriker().getId());
    batsmanViewUtils.decreaseBatsmanRuns(strikerBatsmanViewDto, ballDto.getBatsmanRuns());
    batsmanViewUtils.decrementBallsFaced(strikerBatsmanViewDto);
    if (Objects.equals(ballDto.getWicket().getOutPlayer().getId(), ballDto.getStriker().getId())) {
      batsmanViewUtils.markBatsmanAsNotOut(strikerBatsmanViewDto);
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              ballDto.getInning().getId(), ballDto.getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanAsNotOut(outPlayerViewDto);
      outPlayerViewDto = batsmanViewDao.update(outPlayerViewDto);
      batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, outPlayerViewDto);
    }
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto unprocessRunOutAndWide(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, ballDto.getStriker().getId());
    if (Objects.equals(ballDto.getWicket().getOutPlayer().getId(), ballDto.getStriker().getId())) {
      batsmanViewUtils.markBatsmanAsNotOut(strikerBatsmanViewDto);
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              ballDto.getInning().getId(), ballDto.getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanAsNotOut(outPlayerViewDto);
      outPlayerViewDto = batsmanViewDao.update(outPlayerViewDto);
      batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, outPlayerViewDto);
    }
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto unprocessRunOutAndNoBall(BatsmanViewUnprocessDto request) {
    // Not used. un process run out covers all the cases
    return null;
  }

  @Override
  public BatsmanViewResponseDto unprocessObstructingTheField(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    batsmanViewUtils.decreaseBatsmanRuns(strikerBatsmanViewDto, ballDto.getBatsmanRuns());
    batsmanViewUtils.decrementBallsFaced(strikerBatsmanViewDto);
    if (Objects.equals(ballDto.getWicket().getOutPlayer().getId(), ballDto.getStriker().getId())) {
      batsmanViewUtils.markBatsmanAsNotOut(strikerBatsmanViewDto);
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              ballDto.getInning().getId(), ballDto.getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanAsNotOut(outPlayerViewDto);
      outPlayerViewDto = batsmanViewDao.update(outPlayerViewDto);
      batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, outPlayerViewDto);
    }
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto unprocessObstructingTheFieldAndWide(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    if (Objects.equals(ballDto.getWicket().getOutPlayer().getId(), ballDto.getStriker().getId())) {
      batsmanViewUtils.markBatsmanAsNotOut(strikerBatsmanViewDto);
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              ballDto.getInning().getId(), ballDto.getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanAsNotOut(outPlayerViewDto);
      outPlayerViewDto = batsmanViewDao.update(outPlayerViewDto);
      batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, outPlayerViewDto);
    }
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto unprocessObstructingTheFieldAndNoBall(BatsmanViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    List<BatsmanViewDto> batsmanViewDtoList = batsmanViewDao.getAllBatsmanViewForInning(request.getBallDto().getInning().getId());
    BatsmanViewDto strikerBatsmanViewDto = batsmanViewUtils.getPlayerBatsmanViewDtoFromAllBatsmanViewDtos(batsmanViewDtoList, request.getBallDto().getStriker().getId());
    batsmanViewUtils.decreaseBatsmanRuns(strikerBatsmanViewDto, ballDto.getBatsmanRuns());
    batsmanViewUtils.decrementBallsFaced(strikerBatsmanViewDto);
    if (Objects.equals(ballDto.getWicket().getOutPlayer().getId(), ballDto.getStriker().getId())) {
      batsmanViewUtils.markBatsmanAsNotOut(strikerBatsmanViewDto);
    } else {
      BatsmanViewDto outPlayerViewDto =
          batsmanViewDao.getPlayerBatsmanViewForInningAndPlayer(
              ballDto.getInning().getId(), ballDto.getWicket().getOutPlayer().getId());
      batsmanViewUtils.markBatsmanAsNotOut(outPlayerViewDto);
      outPlayerViewDto = batsmanViewDao.update(outPlayerViewDto);
      batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, outPlayerViewDto);
    }
    strikerBatsmanViewDto = batsmanViewDao.update(strikerBatsmanViewDto);
    batsmanViewUtils.replaceBatsmanViewDtoInBatsmanViewDtoList(batsmanViewDtoList, strikerBatsmanViewDto);
    return BatsmanViewResponseDto.builder().batsmanViewDtoList(batsmanViewDtoList).build();
  }

  @Override
  public BatsmanViewResponseDto unprocessCaughtBehind(BatsmanViewUnprocessDto request) {
    // No need
    return null;
  }

  @Override
  public BatsmanViewResponseDto unprocessLegBeforeWicket(BatsmanViewUnprocessDto request) {
    // No need
    return null;
  }
}
