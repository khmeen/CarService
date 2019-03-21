package com.example.carservice.dto;

import javax.validation.constraints.NotBlank;

public class CarRequest {
    @NotBlank
    private String nazwa;
    @NotBlank
    private String modelSamochodu;

    public CarRequest() {
    }

    public CarRequest(@NotBlank String nazwa, @NotBlank String modelSamochodu) {
        this.nazwa = nazwa;
        this.modelSamochodu = modelSamochodu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getModelSamochodu() {
        return modelSamochodu;
    }

    public void setModelSamochodu(String modelSamochodu) {
        this.modelSamochodu = modelSamochodu;
    }
}
