package com.kucher.la56.exception;

public class SensorNotFoundExeption extends RuntimeException{

    public SensorNotFoundExeption(Integer idsensor){
        super("No element with id = " + idsensor);
    }

}
