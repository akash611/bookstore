package com.akash.bookstore.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	@Pointcut("execution(* com.akash.bookstore.service.*.*(..))")
	public void serviceMethodExecution() {}
	
	@Before("execution(* com.akash.bookstore.controller.*.*(..))")
	public void logControllerMethodExecution(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getName();
		System.out.println("Method " + methodName + " in class " + className + " is being executed.");
	}
	
	@After("serviceMethodExecution()")
	public void logServiceMethodExecution(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("Argument passed to " + methodName + ": ");
		for (Object arg : args) {
			System.out.println(arg.toString());
		}
	}
	
	@AfterReturning(pointcut="execution(* com.akash.bookstore.service.*.*(..))", returning = "result")
	public void logMethodReturnValue(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Method " + methodName + " returned: " + result);
	}
}