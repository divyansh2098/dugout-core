package com.dugout.dugoutcore.models;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.Map;

@Entity
@Table(name = "dugout_cache")
@Getter
@Setter
public class Config extends BaseModel {
  @Type(JsonType.class)
  @Column(columnDefinition = "json")
  Map<String, Object> cache;
}
