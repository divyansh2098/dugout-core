package com.dugout.dugoutcore.service;

import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.dto.RecordBallResponseDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;

public interface BallRecordService {
  RecordBallResponseDto recordBall(BallProcessRequestDto ballRequestDto)
      throws DugoutDataFetchingException;

  BallDto getBallById(Long id);
}
