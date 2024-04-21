package com.dugout.dugoutcore.resolvers;

import com.dugout.dugoutcore.dto.BallProcessRequestDto;
import com.dugout.dugoutcore.dto.RecordBallResponseDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.BallRecordService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class BallResolver {
  @NonNull BallRecordService ballRecordService;

  @DgsMutation
  public RecordBallResponseDto recordBall(
      @InputArgument("ball") BallProcessRequestDto ballRequestDto)
      throws DugoutDataFetchingException {
    return ballRecordService.recordBall(ballRequestDto);
  }
}
