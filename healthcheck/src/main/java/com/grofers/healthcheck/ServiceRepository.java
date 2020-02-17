package com.grofers.healthcheck;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Integer> {

    @Query("SELECT s from Service s where s.serviceName=?1 and s.serviceEnvironment=?2")
    Service findServiceHealthCheckURL(String serviceName, String serviceEnvironment);
}
