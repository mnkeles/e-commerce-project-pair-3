package com.etiya.ecommercepair3.core.utils.results;

public class ErrorResult extends Result{
    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String message) {
        super(false,message);
    }
}
