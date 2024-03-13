package com.dugout.dugoutcore.resolvers;

import com.dugout.dugoutcore.dto.TeamDto;
import com.dugout.dugoutcore.service.TeamService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@DgsComponent
@AllArgsConstructor
public class TeamResolver {

  @NonNull TeamService teamService;

  @DgsMutation
  public TeamDto createTeam(@InputArgument("team") TeamDto teamDto) {
    return teamService.createTeam(teamDto);
  }
}
