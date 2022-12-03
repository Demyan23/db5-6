package com.kucher.la56.exception;

public class UserNotFoundExeption extends RuntimeException{

    public UserNotFoundExeption(Integer iduser){
        super("No element with id = " + iduser);
    }

}
