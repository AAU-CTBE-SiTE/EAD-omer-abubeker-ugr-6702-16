
package com.example.restaurantorderingsystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.restaurantorderingsystem.service.OrderService.*(..))")
    public void logOrderOperations(JoinPoint joinPoint) {

        System.out.println(
                "AOP LOG: Executing method: "
                        + joinPoint.getSignature().getName()
        );
    }
}
