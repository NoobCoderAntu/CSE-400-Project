package com.anupam.cseclassapplication.repo;

import org.springframework.data.repository.CrudRepository;

import com.anupam.cseclassapplication.entity.DatabaseEntity;

public interface EntityRepo extends CrudRepository <DatabaseEntity,Long> {
    
}
