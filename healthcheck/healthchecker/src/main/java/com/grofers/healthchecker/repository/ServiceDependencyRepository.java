package com.grofers.healthchecker.repository;

import com.grofers.healthchecker.model.ServiceDependency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceDependencyRepository extends JpaRepository<ServiceDependency, Integer> {

    @Query("Select sd.dependency_service.id from ServiceDependency sd where sd.service.id=?1")
    public List<Integer> getDependency(Integer id);
}
