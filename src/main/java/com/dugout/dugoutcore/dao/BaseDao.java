package com.dugout.dugoutcore.dao;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

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

  protected E convertToEntity(T dto) {
    E entity = this.entitySupplier.get();
    BeanUtils.copyProperties(dto, entity);
    return entity;
  }

  protected T convertToDto(E entity) {
    T dto = dtoSupplier.get();
    BeanUtils.copyProperties(entity, dto);
    return dto;
  }

  public T create(T dto) {
    E entity = convertToEntity(dto);
    E savedEntity = repository.save(entity);
    return convertToDto(savedEntity);
  }
}
