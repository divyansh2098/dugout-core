package com.dugout.dugoutcore.dao;

import com.dugout.dugoutcore.dto.BaseDto;
import com.dugout.dugoutcore.exceptions.DugoutDataFetchingException;
import com.dugout.dugoutcore.models.BaseModel;
import com.dugout.dugoutcore.pojo.DugoutError;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

public class BaseDao<E extends BaseModel, T extends BaseDto, R extends JpaRepository<E, Long>> {

  R repository;
  @Autowired ModelMapper modelMapper;

  Class<T> dtoClass;
  Class<E> entityClass;

  BaseDao(R repository, Class<E> entityClass, Class<T> dtoClass) {
    this.repository = repository;
    this.entityClass = entityClass;
    this.dtoClass = dtoClass;
  }

  @SneakyThrows
  protected E convertToEntity(T dto) {
    return modelMapper.map(dto, entityClass);
  }

  @SneakyThrows
  protected T convertToDto(E entity) {
    return modelMapper.map(entity, dtoClass);
  }

  public T create(T dto) {
    E entity = convertToEntity(dto);
    E savedEntity = repository.save(entity);
    return convertToDto(savedEntity);
  }

  public T getById(Long id) {
    if (id == null) {
      return null;
    }
    Optional<E> entity = repository.findById(id);
    return entity.map(this::convertToDto).orElse(null);
  }
  
  public List<T> getByIdIn(List<Long> ids) {
    if (ObjectUtils.isEmpty(ids)) {
      return Collections.emptyList();
    }
    List<E> entities = repository.findAllById(ids);
    return entities.stream().map(this::convertToDto).collect(Collectors.toList());
  }

  public T update(T dto) throws DugoutDataFetchingException {
    E existingEntity = repository.findById(dto.getId()).orElse(null);
    if (ObjectUtils.isEmpty(existingEntity)) {
      throw new DugoutDataFetchingException(
          DugoutError.builder()
              .message(String.format("Resource %s with id %s not found", entityClass.getName(), dto.getId()))
              .build(),
          HttpStatus.BAD_REQUEST);
    }
    dto.setCreatedOn(existingEntity.getCreatedOn());
    return convertToDto(repository.save(convertToEntity(dto)));
  }
}
