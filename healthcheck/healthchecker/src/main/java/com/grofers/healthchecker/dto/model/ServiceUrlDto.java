package com.grofers.healthchecker.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServiceUrlDto {
    private String serviceName;
    private String environment;
    private String url;
}
