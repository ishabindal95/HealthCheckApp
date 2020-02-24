package com.grofers.healthchecker.repository;

import com.grofers.healthchecker.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

    @Query("Select s.id from Service s where s.serviceName=?1")
    public Integer findIdByServiceName(String ServiceName);


    public Service findByServiceName(String serviceName);
}
