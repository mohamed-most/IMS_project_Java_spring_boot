package com.mohamedmostafa.IMS_project.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"status", "message", "data", "timestamp"}) // set order
public class Response<T> {

    @Builder.Default
    private final LocalDateTime timestamp = LocalDateTime.now();

    private final int status;
    private final String message;
    private final T data;

    public static <T> Response<T> success(String message, T data) {
        return Response.<T>builder()
                .status(HttpStatus.OK.value())
                .message(message)
                .data(data)
                .build();
    }

    public static <T> Response<T> error(HttpStatus status, String message) {
        return Response.<T>builder()
                .status(status.value())
                .message(message)
                .build();
    }

}
