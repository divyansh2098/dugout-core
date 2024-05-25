package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.TeamPlayerDto;
import com.dugout.dugoutcore.models.TeamPlayer;
import com.dugout.dugoutcore.repository.TeamPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamPlayerDao extends BaseDao<TeamPlayer, TeamPlayerDto, TeamPlayerRepository> {

  @Autowired
  TeamPlayerDao(TeamPlayerRepository teamPlayerRepository) {
    super(teamPlayerRepository, TeamPlayer.class, TeamPlayerDto.class);
  }
}
