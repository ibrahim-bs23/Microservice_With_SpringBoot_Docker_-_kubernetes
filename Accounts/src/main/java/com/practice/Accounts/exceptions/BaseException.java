package com.practice.Accounts.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Data
public class BaseException {
    private String description;
    private HttpStatus httpStatus;
    private  String message;
    private LocalDateTime localDateTime;
}
