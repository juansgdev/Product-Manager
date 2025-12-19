package com.techsolutions.productmanager.response.error;

import java.util.List;

public record ApiError(List<String> errors) {
    public static ApiError of(String error) {
        return new ApiError(List.of(error));
    }

    public static ApiError of(List<String> errors) {
        return new ApiError(errors);
    }
}
