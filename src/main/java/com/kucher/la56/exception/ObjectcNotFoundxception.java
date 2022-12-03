package com.kucher.la56.exception;

import com.kucher.la56.domain.Objectc;

public class ObjectcNotFoundxception extends RuntimeException{

    public ObjectcNotFoundxception(Integer idobject){
        super("No element with id = " + idobject);
    }

}
