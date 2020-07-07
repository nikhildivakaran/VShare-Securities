package com.virtusaproject.vsharesecurities.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.HashMap;



@Getter
@RequiredArgsConstructor
public class ErrorDto {
    public static final ErrorDto PAGE_NOT_FOUND = new ErrorDto(404, "Page not found", "The page that you are looking for is currently not available");
    public static final ErrorDto INTERNAL_SERVER_ERROR_DTO = new ErrorDto(500, "Internal server error", "Something went wrong at the server side");

    private final int status;
    private final String title;
    private final String description;

    private final static HashMap<HttpStatus, ErrorDto> resolverMap = new HashMap<>();

    static {
        resolverMap.put(HttpStatus.NOT_FOUND, PAGE_NOT_FOUND);
        resolverMap.put(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_DTO);
    }

    public static ErrorDto resolve(HttpStatus status) {
        return resolverMap.getOrDefault(status, new ErrorDto(status.value(), status.getReasonPhrase(), "Unknown error occurred"));
    }
}
