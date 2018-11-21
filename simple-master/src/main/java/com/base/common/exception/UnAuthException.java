package com.base.common.exception;

public class UnAuthException extends RuntimeException {

    public UnAuthException(){
        super();
    }

    public UnAuthException(String message){
        super(message);
    }

}
