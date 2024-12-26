package com.dugout.dugoutcore.resolvers;

import com.dugout.dugoutcore.cache.DugoutConfigCache;
import com.dugout.dugoutcore.models.Config;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class ConfigResolver {

  @NonNull DugoutConfigCache dugoutConfigCache;

  @DgsQuery
  public Config getFormConfig(@InputArgument String configName) {
    return dugoutConfigCache.getFormConfig(configName);
  }
}
