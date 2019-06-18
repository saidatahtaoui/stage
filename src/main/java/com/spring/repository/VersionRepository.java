package com.spring.repository;
import org.springframework.data.repository.CrudRepository;

import com.spring.model.Version;


public interface VersionRepository extends  CrudRepository<Version,Integer> {

}
