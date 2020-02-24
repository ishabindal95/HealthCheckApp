package com.grofers.healthchecker.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ServiceDependency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="service_id", referencedColumnName = "id")
    Service service;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dependency_service_id", referencedColumnName = "id")
    Service dependency_service;

}
