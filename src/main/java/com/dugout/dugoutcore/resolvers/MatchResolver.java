package com.dugout.dugoutcore.resolvers;

import com.dugout.dugoutcore.dto.AddSquadToMatchRequestDto;
import com.dugout.dugoutcore.dto.MatchRequestDto;
import com.dugout.dugoutcore.dto.MatchDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.impl.MatchService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@DgsComponent
@AllArgsConstructor
public class MatchResolver {

  @NonNull MatchService matchService;

  @DgsMutation
  public MatchDto createMatch(@InputArgument("match") MatchRequestDto matchRequestDto) {
    return matchService.createMatch(matchRequestDto);
  }

  @DgsMutation
  public MatchDto addSquadToMatch(
      @InputArgument("addSquadInput") AddSquadToMatchRequestDto addSquadToMatchRequestDto)
      throws DugoutDataFetchingException {
    return matchService.addSquad(addSquadToMatchRequestDto);
  }
}
