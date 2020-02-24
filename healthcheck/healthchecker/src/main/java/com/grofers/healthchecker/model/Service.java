package com.grofers.healthchecker.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String serviceName;
    private String healthEndpoint;
    @OneToMany(mappedBy = "service")
    private List<ServiceUrl> serviceUrls;

    @OneToMany(mappedBy = "service")
    List<ServiceDependency> serviceDependencies;

    @OneToMany(mappedBy = "dependency_service")
    List<ServiceDependency> dependencyServiceDependencies;
}
