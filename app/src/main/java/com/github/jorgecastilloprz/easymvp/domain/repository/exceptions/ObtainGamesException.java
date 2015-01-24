package com.github.jorgecastilloprz.easymvp.domain.repository.exceptions;

/**
 * Obtain games exception wrapper*
 * * 
 * Created by jorge on 22/01/15.
 */
public class ObtainGamesException extends RuntimeException {

    private String message = "An error ocurred while trying to get games.";
    
    public ObtainGamesException() {}
    
    public ObtainGamesException(String message) {
        this.message += "\n" + message;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
}
