package com.dugout.dugoutcore.resolvers;

import com.dugout.dugoutcore.dto.GroundDto;
import com.dugout.dugoutcore.service.impl.GroundService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@DgsComponent
@AllArgsConstructor
public class GroundResolver {
  @NonNull GroundService groundService;

  @DgsMutation
  public GroundDto createGround(@InputArgument("ground") GroundDto groundDto) {
    return groundService.createGround(groundDto);
  }

  @DgsQuery
  public GroundDto getGroundById(@InputArgument Long id) {
    return groundService.getGroundById(id);
  }
}
