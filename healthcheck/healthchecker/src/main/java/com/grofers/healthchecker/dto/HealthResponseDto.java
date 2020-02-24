package com.grofers.healthchecker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class HealthResponseDto {

    private Double healthScore;

    public HealthResponseDto() {
    }

    public HealthResponseDto(Double healthScore) {
        this.healthScore = healthScore;
    }

    public Double getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(Double healthScore) {
        this.healthScore = healthScore;
    }
}
