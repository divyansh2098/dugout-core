package com.dugout.dugoutcore.service.impl.views;

import com.dugout.dugoutcore.dao.BowlerViewDao;
import com.dugout.dugoutcore.dto.*;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.BallProcessingService;
import com.dugout.dugoutcore.service.impl.UserService;
import com.dugout.dugoutcore.util.BallProcessingUtils;
import com.dugout.dugoutcore.util.BowlerViewUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.dugout.dugoutcore.ApplicationConstants.*;

@Service
@RequiredArgsConstructor
public class BowlerViewServiceImpl
    implements BallProcessingService<BowlerViewResponseDto, BowlerViewProcessDto, BowlerViewUnprocessDto> {
  @NonNull private BowlerViewDao bowlerViewDao;
  @NonNull private UserService userService;
  @NonNull private BallProcessingUtils ballProcessingUtils;
  @NonNull private final BowlerViewUtils bowlerViewUtils;

  @Override
  public BowlerViewResponseDto processNoBall(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler's extras and runs will increase
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processNoBallLegBye(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler's extras and runs will increase
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processNoBallBye(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler's extras and runs will increase
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processWideBall(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler's extras and runs will increase
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processFourRuns(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler runs will increase
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + FOUR_RUNS);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processSixRuns(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler runs will increase
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + SIX_RUNS);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processRun(BowlerViewProcessDto request) throws DugoutDataFetchingException {
    // Bowler runs will increase
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processLegBye(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler runs will increase
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processWicket(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowler wickets will increase
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processStumpAndWide(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // bowlers wicket and runs will increase
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processRunOut(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setNumBalls(bowlerViewDto.getNumBalls() + 1);
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processRunOutAndWide(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processRunOutAndNoBall(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processObstructingTheField(BowlerViewProcessDto request) throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns());
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processObstructingTheFieldAndWide(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + ONE_RUN);
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + ONE_RUN);
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto processObstructingTheFieldAndNoBall(BowlerViewProcessDto request)
      throws DugoutDataFetchingException {
    // Bowlers wicket will increment and runs will increase if there are any runs
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, request.getBallDto().getBowler().getId());
    bowlerViewDto.setWickets(bowlerViewDto.getWickets() + 1);
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() + request.getBallDto().getBowlerRuns());
    if (request.getBallDto().getBowlerRuns() != null && request.getBallDto().getBowlerRuns() > 0) {
      bowlerViewDto.setRuns(bowlerViewDto.getRuns() + request.getBallDto().getBowlerRuns());
    }
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto unprocessNoBall(BowlerViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, ballDto.getBowler().getId());
    bowlerViewDto.setRuns(bowlerViewDto.getRuns() - ballDto.getBowlerRuns());
    bowlerViewDto.setExtras(bowlerViewDto.getExtras() - (ONE_RUN + ballDto.getBowlerRuns()));
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto unprocessNoBallLegBye(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessNoBallBye(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessWideBall(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessWideBallBye(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessFourRuns(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessSixRuns(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessRun(BowlerViewUnprocessDto request)
      throws DugoutDataFetchingException {
    BallDto ballDto = request.getBallDto();
    List<BowlerViewDto> bowlerViewDtoList = bowlerViewDao.getAllPlayerBowlerViewFromInning(request.getBallDto().getInning().getId());
    BowlerViewDto bowlerViewDto = bowlerViewUtils.getPlayerBowlerViewDtoFromAllBowlerViewDtos(bowlerViewDtoList, ballDto.getBowler().getId());
    bowlerViewUtils.decreaseBowlerRuns(bowlerViewDto, ballDto.getBowlerRuns());
    bowlerViewUtils.reduceBalls(bowlerViewDto);
    bowlerViewDto = bowlerViewDao.update(bowlerViewDto);
    bowlerViewUtils.replaceBowlerViewDtoInBowlerViewDtoList(bowlerViewDtoList, bowlerViewDto);
    return BowlerViewResponseDto.builder().bowlerViewDtoList(bowlerViewDtoList).build();
  }

  @Override
  public BowlerViewResponseDto unprocessLegBye(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessBowled(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessCatch(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessCaughtAndBowled(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessStump(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessStumpAndWide(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessRunOut(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessRunOutAndWide(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessRunOutAndNoBall(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessObstructingTheField(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessObstructingTheFieldAndWide(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessObstructingTheFieldAndNoBall(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessCaughtBehind(BowlerViewUnprocessDto request) {
    return null;
  }

  @Override
  public BowlerViewResponseDto unprocessLegBeforeWicket(BowlerViewUnprocessDto request) {
    return null;
  }
}
