package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.TeamDto;
import com.dugout.dugoutcore.models.Team;
import com.dugout.dugoutcore.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamDao extends BaseDao<Team, TeamDto, TeamRepository> {

  @Autowired
  TeamDao(TeamRepository teamRepository) {
    super(teamRepository, Team::new, TeamDto::new);
  }
}
