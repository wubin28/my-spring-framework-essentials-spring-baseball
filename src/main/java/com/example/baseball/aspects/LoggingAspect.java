package com.example.baseball.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(String playGame())")
    public Object checkForRain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        boolean isRainy = Math.random() < 0.5;
        Object result = null;
        if (isRainy) {
            logger.info(proceedingJoinPoint.getTarget() + " rained out");
        } else {
            result = proceedingJoinPoint.proceed();
            logger.info(result.toString() + " win!");
        }
        return result;
    }
}
