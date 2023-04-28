package com.etiya.ecommercepair3.core.results;

public class ErrorResult extends Result{
    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String message) {
        super(false,message);
    }
}
