package com.github.daria80.app.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class StudentNotFoundException extends RuntimeException {

    private String message;
    private HttpStatus status;

    public StudentNotFoundException(String message) {
        this.message = message;
        this.status = HttpStatus.NOT_FOUND;
    }


}
