package com.example.retrofitandroid_sample.model;

public class Currency {

    private boolean success;
    private com.example.retrofitandroid_sample.model.error error;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public error getError() {
        return error;
    }

    public void setError(error error) {
        this.error = error;
    }
}
