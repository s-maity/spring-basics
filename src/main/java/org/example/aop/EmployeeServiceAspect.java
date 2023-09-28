package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

    @Before(value = "execution(* org.example.aop.EmployeeService.*(..))")
    public void beforeAdviceAll(JoinPoint joinPoint) {
        System.out.println("beforeAdviceAll method:" + joinPoint.getSignature());
    }

    @Before(value = "execution(* org.example.aop.EmployeeService.*(..)) and args(empId)")
    public void beforeAdvice(JoinPoint joinPoint, int empId) {
        System.out.println("Before method:" + joinPoint.getSignature());
        System.out.println("Fetching Employee with id - " + empId);
        if (empId >= 100) throw new IllegalArgumentException("Invalid empId:" + empId);
    }

    @After(value = "execution(* org.example.aop.EmployeeService.*(..)) and args(empId)")
    public void afterAdvice(JoinPoint joinPoint, int empId) {
        System.out.println("After method:" + joinPoint.getSignature());

        System.out.println("Fetched Employee with id - " + empId);
    }

    // Not working if @Before & @After is present at the same time
    @AfterThrowing(pointcut = "execution(* org.example.aop.EmployeeService.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, RuntimeException ex) {
        System.out.println("After throwing:" + ex.getMessage());
    }

    @Around(value = "execution(* org.example.aop.EmployeeService.isValidName(..)) and args(name)")
    public boolean aroundAdvice(ProceedingJoinPoint joinPoint, String name) throws Throwable {
        System.out.println("Around method:" + joinPoint.getSignature());
        if (name != null && !name.isBlank()) {
            return (boolean) joinPoint.proceed();
        } else {
            return false;
        }
    }

    // This is similar to @After but it’s run only after a normal execution of the method.
   /* @AfterReturning(value = "")
    public void afterReturning() {

    }*/
}