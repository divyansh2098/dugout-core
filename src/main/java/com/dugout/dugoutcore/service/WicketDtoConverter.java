package com.dugout.dugoutcore.service;

import com.dugout.dugoutcore.dto.WicketDto;
import com.dugout.dugoutcore.dto.WicketMetaRequestDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;

public interface WicketDtoConverter {
  WicketDto convertToWicketDto(WicketMetaRequestDto wicketMetaRequestDto, Long inningId) throws DugoutDataFetchingException;
}
