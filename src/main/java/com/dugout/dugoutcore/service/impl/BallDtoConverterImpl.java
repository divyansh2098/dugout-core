package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dto.BallDto;
import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.BallDtoConverter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BallDtoConverterImpl implements BallDtoConverter {
  @NonNull InningService inningService;
  @NonNull UserService userService;

  @Override
  public BallDto convertBallRequestToBallDto(BallProcessRequestDto request)
      throws DugoutDataFetchingException {
    return BallDto.builder()
        .ballNumber(request.getBallNumber())
        .inning(inningService.getInningById(request.getInningId()))
        .striker(userService.getUser(request.getStrikerId()))
        .nonStriker(userService.getUser(request.getNonStrikerId()))
        .bowler(userService.getUser(request.getBowlerId()))
        .wicketKeeper(userService.getUser(request.getWicketKeeperId()))
        .type(request.getBallType())
        .isFreeHit(request.getIsFreeHit())
        .comment(request.getComment())
        .build();
  }
}
