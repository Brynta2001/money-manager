package com.bp.moneymanager.dto;

import java.util.List;

public class ErrorResponseDto {
    private int status;
    private String title;
    private List<String> errors;

    public ErrorResponseDto(int status, String title, List<String> errors) {
        this.status = status;
        this.title = title;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
