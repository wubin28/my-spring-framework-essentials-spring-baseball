package com.example.baseball.domain;

import org.springframework.stereotype.Component;

@Component
public class Cubs implements Team {
    @Override
    public String getName() {
        return "Chicago cubs";
    }
}
