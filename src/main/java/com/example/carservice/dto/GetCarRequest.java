package com.example.carservice.dto;

import javax.validation.constraints.NotBlank;

public class GetCarRequest {

    @NotBlank
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
