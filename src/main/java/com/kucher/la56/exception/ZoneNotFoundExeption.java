package com.kucher.la56.exception;

public class ZoneNotFoundExeption extends RuntimeException{

    public ZoneNotFoundExeption(Integer idzone){
        super("No element with id = " + idzone);
    }
}