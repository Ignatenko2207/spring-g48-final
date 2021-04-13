package ua.mainacademy.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RequestDTO<T> {

    @NotNull
    private T data;
}
