
package com.example.restaurantorderingsystem.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(* com.example.restaurantorderingsystem.service.OrderService.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint)
            throws Throwable {

        long start = System.nanoTime();

        try {
            return joinPoint.proceed();
        } finally {

            long end = System.nanoTime();

            double executionTime = (end - start) / 1_000_000.0;

            System.out.println(
                    "PERFORMANCE: "
                            + joinPoint.getSignature().getName()
                            + " executed in "
                            + executionTime
                            + " ms"
            );
        }
    }
}
