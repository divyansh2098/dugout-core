package com.dugout.dugoutcore.resolvers;

import com.dugout.dugoutcore.dto.BallRequestDto;
import com.dugout.dugoutcore.dto.RecordBallResponseDto;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class BallResolver {
  @DgsMutation
  public RecordBallResponseDto recordBall(@InputArgument("ball") BallRequestDto ballRequestDto) {
    return null;
  }
}
