package com.dugout.dugoutcore.graphql.context;

import com.dugout.dugoutcore.dto.UserSessionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DugoutGraphqlContext {
  UserSessionDTO userSessionDTO;
}
