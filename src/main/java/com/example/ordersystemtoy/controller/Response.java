package com.example.ordersystemtoy.controller;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/*
* 응답 커스텀
* */
@Getter
public class Response<T> {
    private final HttpStatus status;    // 상태
    private final String message;   // 메시지
    private final T data;   // 반환 데이터

    public Response(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(HttpStatus.OK, "SUCCESS", data);
    }

    public static <T> Response<T> fail(String errorMessage) {
        return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage, null);
    }
}
