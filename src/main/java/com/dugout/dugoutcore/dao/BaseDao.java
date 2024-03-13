package com.dugout.dugoutcore.dao;

import java.util.Optional;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseDao<E, T, R extends JpaRepository<E, Long>> {

  R repository;
  ModelMapper mapper;

  Class<T> dtoClass;
  Class<E> entityClass;

  BaseDao(R repository, Class<E> entityClass, Class<T> dtoClass) {
    this.repository = repository;
    this.mapper = new ModelMapper();
    this.entityClass = entityClass;
    this.dtoClass = dtoClass;
  }

  @SneakyThrows
  protected E convertToEntity(T dto) {
    return mapper.map(dto, entityClass);
  }

  @SneakyThrows
  protected T convertToDto(E entity) {
    return mapper.map(entity, dtoClass);
  }

  public T create(T dto) {
    E entity = convertToEntity(dto);
    E savedEntity = repository.save(entity);
    return convertToDto(savedEntity);
  }

  public T getById(Long id) {
    Optional<E> entity = repository.findById(id);
    return entity.map(this::convertToDto).orElse(null);
  }
}
