package com.mycom.myapplications.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycom.myapplications.backend.model.Component;

@Repository
public interface ComponentRepository extends CrudRepository<Component, Long> {

}
