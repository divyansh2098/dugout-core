package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dao.BallDao;
import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.dto.RecordBallResponseDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.BallRecordService;
import com.dugout.dugoutcore.service.impl.views.BallViewServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class BallRecordServiceImpl implements BallRecordService {
  @NonNull ModelMapper modelMapper;
  @NonNull BallViewServiceImpl ballProcessingService;

  @NonNull BallDao ballDao;

  @Override
  @Transactional
  public RecordBallResponseDto recordBall(BallProcessRequestDto ballRequestDto)
      throws DugoutDataFetchingException {
    try {
      BallDto ballDto = ballProcessingService.processBall(ballRequestDto);
      return RecordBallResponseDto.builder()
          .strikerId(ballDto.getStriker().getId())
          .nonStrikerId(ballDto.getNonStriker().getId())
          .success(true)
          .isNextFreeHit(ballDto.getIsNextFreeHit())
          .nextBallNumber(ballDto.getNextBallNumber())
          .isOverComplete(ballDto.getIsOverComplete())
          .build();
    } catch (DugoutDataFetchingException exception) {
      log.info(
          "Encountered Exception while recording ball, BallType={}, BallNumber={}",
          ballRequestDto.getBallType(),
          ballRequestDto.getBallNumber());
      throw exception;
    }
  }

  @Override
  public BallDto getBallById(Long id) {
    return ballDao.getById(id);
  }
}
