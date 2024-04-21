package com.dugout.dugoutcore.dao;

import java.util.Optional;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseDao<E, T, R extends JpaRepository<E, Long>> {

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
    Optional<E> entity = repository.findById(id);
    return entity.map(this::convertToDto).orElse(null);
  }
}
