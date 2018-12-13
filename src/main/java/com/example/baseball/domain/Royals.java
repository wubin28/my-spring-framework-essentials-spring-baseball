package com.example.baseball.domain;

import org.springframework.stereotype.Component;

@Component
public class Royals implements Team {
    @Override
    public String getName() {
        return "Kansas City Royals";
    }
}
