package com.example.demo;

public class PositionNotFoundException extends RuntimeException {
    public PositionNotFoundException(String code) {
        super("Could not find position " + code);
    }
}
