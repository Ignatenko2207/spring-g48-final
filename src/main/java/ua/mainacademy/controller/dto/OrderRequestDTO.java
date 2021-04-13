package ua.mainacademy.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderRequestDTO {

    @NotNull
    private Integer userId;
}
