package com.dugout.dugoutcore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ground")
@Data
public class Ground extends BaseModel {
  String lat; // Change to point data type
  String lon;
  String address;
}
