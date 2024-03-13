package com.dugout.dugoutcore.dao;

import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.function.Supplier;

public class BaseDao<E, T, R extends JpaRepository<E, Long>> {

  R repository;
  Supplier<E> entitySupplier;
  Supplier<T> dtoSupplier;

  BaseDao(R repository, Supplier<E> entitySupplier, Supplier<T> dtoSupplier) {
    this.repository = repository;
    this.entitySupplier = entitySupplier;
    this.dtoSupplier = dtoSupplier;
  }

  @SneakyThrows
  protected E convertToEntity(T dto) {
    E entity = this.entitySupplier.get();
    BeanUtils.copyProperties(entity, dto);
    return entity;
  }

  @SneakyThrows
  protected T convertToDto(E entity) {
    T dto = dtoSupplier.get();
    BeanUtils.copyProperties(dto, entity);
    return dto;
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
