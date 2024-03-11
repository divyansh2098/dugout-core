package com.dugout.dugoutcore.resolvers;

import com.dugout.dugoutcore.dto.TournamentDto;
import com.dugout.dugoutcore.service.TournamentService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class TournamentResolver {

  @NonNull TournamentService tournamentService;

  @DgsMutation
  public TournamentDto createTournament(@InputArgument("tournament") TournamentDto tournamentDto) {
    return tournamentService.createTournament(tournamentDto);
  }
}
