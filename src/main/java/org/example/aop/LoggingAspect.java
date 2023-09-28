package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(AfterLog)")
    public void afterLogPointCut(){}

    @After("afterLogPointCut()")
    public void logAfterService(JoinPoint joinPoint) {
        System.out.println("AfterLog:" + joinPoint.getSignature());
    }
}
