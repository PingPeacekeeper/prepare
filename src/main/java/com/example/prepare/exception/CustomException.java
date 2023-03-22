package com.example.prepare.exception;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class CustomException extends RuntimeException {
    private int code;

    public CustomException() {
        super();
    }

    public CustomException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
