package com.dugout.dugoutcore.service.impl;

import com.dugout.dugoutcore.dto.WicketDto;
import com.dugout.dugoutcore.dto.WicketMetaRequestDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.service.WicketDtoConverter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WicketDtoConverterImpl implements WicketDtoConverter {

  @NonNull InningService inningService;
  @NonNull UserService userService;

  @Override
  public WicketDto convertToWicketDto(WicketMetaRequestDto wicketMetaRequestDto, Long inningId)
      throws DugoutDataFetchingException {
    return WicketDto.builder()
        .innings(inningService.getInningById(inningId))
        .outPlayer(userService.getUser(wicketMetaRequestDto.getOutPlayerId()))
        .fielder(userService.getUser(wicketMetaRequestDto.getFielderId()))
        .type(wicketMetaRequestDto.getWicketType())
        .build();
  }
}
