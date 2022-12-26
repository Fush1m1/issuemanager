package com.example.demo;

class IssueNotFoundException extends RuntimeException {

    IssueNotFoundException(String code) {
        super("Could not find issue " + code);
    }
}