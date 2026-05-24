package com.example.lesson.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class SecurityLoggingAspect {

    @AfterThrowing(
            pointcut = "execution(* com.example.lesson.service.impl.*.*(..))",
            throwing = "exception"
    )
    public void logServiceError(
            JoinPoint joinPoint,
            Exception exception
    ) {

        String className = joinPoint
                .getTarget()
                .getClass()
                .getSimpleName();

        String methodName = joinPoint
                .getSignature()
                .getName();

        log.error(
                "SECURITY LOG -> Class: {}, Method: {}, Error: {}",
                className,
                methodName,
                exception.getMessage()
        );
    }
}