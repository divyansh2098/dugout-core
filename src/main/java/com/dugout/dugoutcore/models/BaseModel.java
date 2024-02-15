package com.dugout.dugoutcore.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "created_on")
    @CreationTimestamp
    Date createdOn;

    @Column(name = "updated_on")
    @UpdateTimestamp
    Date updatedOn;
}
