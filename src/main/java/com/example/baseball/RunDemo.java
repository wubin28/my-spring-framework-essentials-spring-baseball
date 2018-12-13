package com.example.baseball;

import com.example.baseball.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.NumberFormat;

public class RunDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        NumberFormat numberFormat = context.getBean(NumberFormat.class);
        double amount = 12345678.9012345;
        System.out.println(numberFormat.format(amount));
    }
}
