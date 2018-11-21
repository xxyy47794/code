package com.base.common.exception;

/**
 * @author John.Zhang
 * @version 1.0
 * @date 2018/11/19
 */
public class SimpleException extends RuntimeException{


    public SimpleException(){
        super();
    }

    public SimpleException(String message){
        super(message);
    }

}
