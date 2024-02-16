package com.dugout.dugoutcore.graphql;

import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.netflix.graphql.types.errors.TypedGraphQLError;
import graphql.GraphQLError;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.execution.DataFetcherExceptionHandlerResult;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class CustomDataFetcherExceptionHandler implements DataFetcherExceptionHandler {
  @Override
  @SneakyThrows
  public CompletableFuture<DataFetcherExceptionHandlerResult> handleException(
      DataFetcherExceptionHandlerParameters handlerParameters) {
    if (handlerParameters.getException().getCause() instanceof DugoutDataFetchingException) {
      DugoutDataFetchingException dugoutDataFetchingException =
          (DugoutDataFetchingException) handlerParameters.getException().getCause();
      Map<String, Object> errorMap = new HashMap<>();
      errorMap.put(handlerParameters.getPath().toString(), dugoutDataFetchingException.getError());
      Map<String, Object> extensions = new HashMap<>();
      extensions.put("errorType", dugoutDataFetchingException.getStatus());
      GraphQLError graphQLError =
          TypedGraphQLError.newBadRequestBuilder()
              .message(dugoutDataFetchingException.getError().getMessage())
              .debugInfo(errorMap)
              .path(handlerParameters.getPath())
              .build();
      DataFetcherExceptionHandlerResult dataFetcherExceptionHandlerResult =
          DataFetcherExceptionHandlerResult.newResult().error(graphQLError).build();
      return CompletableFuture.completedFuture(dataFetcherExceptionHandlerResult);
    } else {
      throw handlerParameters.getException();
    }
  }
}
