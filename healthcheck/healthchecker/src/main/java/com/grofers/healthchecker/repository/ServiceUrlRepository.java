package com.grofers.healthchecker.repository;

import com.grofers.healthchecker.model.ServiceUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceUrlRepository extends JpaRepository<ServiceUrl,Integer> {

    @Query("select concat(su.url, s.healthEndpoint) from ServiceUrl su left join Service s on s.id=su.service.id where s.id in ?1 and su.environment=?2")
    public List<String> getAllHealthEndpoint(List<Integer> serviceIdList, String serviceEnvironment);
}
