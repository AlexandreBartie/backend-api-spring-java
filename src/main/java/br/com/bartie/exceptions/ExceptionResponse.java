package br.com.bartie.exceptions;

import java.io.Serializable;
import java.util.Date;

interface IExceptionResponse {
    Date timestamp = null;
    String message = null;
    String details = null;
}

public class ExceptionResponse implements IExceptionResponse, Serializable {

    private static final long serialVersionUID = 1L;

    final Date timestamp;
    final String message;
    final String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }   
    
}
