package com.dugout.dugoutcore.service;

import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;

public interface BallDtoConverter {
  BallDto convertBallRequestToBallDto(BallProcessRequestDto ballProcessRequestDto) throws DugoutDataFetchingException;
}
