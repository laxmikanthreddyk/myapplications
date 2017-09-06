package com.mycom.myapplications.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycom.myapplications.backend.model.Application;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {

}
