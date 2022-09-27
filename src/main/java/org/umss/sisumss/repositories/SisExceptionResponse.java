package org.umss.sisumss.repositories;

import java.util.Date;

public class SisExceptionResponse {
    private Date timestamp;
    private String message;

    public SisExceptionResponse(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}
