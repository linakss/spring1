package ru.bibonline.demo.entity;

import ru.bibonline.demo.response.BaseResponse;

import java.net.http.HttpResponse;

public class Response {
    public static Response ok(BaseResponse baseResponse) {
        return null;
    }

    public static HttpResponse<Object> badRequest() {
        return null;
    }
}
