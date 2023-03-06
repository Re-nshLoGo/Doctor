package com.geekster.doctor.exception;

public class RecordNotFound extends RuntimeException {
    public RecordNotFound(String msg){
        super(msg);
    }
}
