package com.techsolutions.productmanager.record.error;

import java.util.List;

public record ApiError(List<String> errors) {
    public static ApiError of(String error) {
        return new ApiError(List.of(error));
    }

    public static ApiError of(List<String> errors) {
        return new ApiError(errors);
    }
}