package com.dugout.dugoutcore.graphql.context;

import static com.dugout.dugoutcore.ApplicationConstants.USER_SESSION_ATTRIBUTE;

import com.dugout.dugoutcore.dto.UserSessionDTO;
import com.netflix.graphql.dgs.context.DgsCustomContextBuilderWithRequest;
import java.util.Map;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@Component
public class DugoutGraphqlContextBuilder
    implements DgsCustomContextBuilderWithRequest<DugoutGraphqlContext> {
  @Override
  public DugoutGraphqlContext build(
      @Nullable Map<String, ?> map,
      @Nullable HttpHeaders httpHeaders,
      @Nullable WebRequest webRequest) {
    return new DugoutGraphqlContext(
        (UserSessionDTO)
            ((ServletWebRequest) webRequest).getRequest().getAttribute(USER_SESSION_ATTRIBUTE));
  }
}
