package com.example.baseball;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.NumberFormat;

public class RunDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        NumberFormat numberFormat = context.getBean(NumberFormat.class);
        double amount = 12345678.9012345;
        System.out.println(numberFormat.format(amount));
    }
}
