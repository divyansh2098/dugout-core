package com.dugout.dugoutcore.resolvers;

import com.dugout.dugoutcore.dto.UserDTO;
import com.dugout.dugoutcore.service.UserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
@Slf4j
public class UserResolver {

  @Autowired
  UserService userService;

  UserResolver() {
    log.info("Called");
  }

  @DgsQuery
  public UserDTO getPlayerById(@InputArgument Long id) {
    return userService.getUser(id);
  }

  @DgsMutation
  public UserDTO createPlayer(@InputArgument UserDTO player) {
    return userService.createUser(player);
  }

  @DgsMutation
  public UserDTO updatePlayer(@InputArgument UserDTO player) {
    return userService.updateUser(player);
  }
}
