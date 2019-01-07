package com.iig.gcp.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class AuditAspect {

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* 	com.*.aspects.*.*(..))")
   	public void before(JoinPoint joinPoint){
   		//Advice
   		logger.info(" Check for user access ");
   		logger.info(" Allowed execution for {}", joinPoint);
   	}
	
	
	@Before("execution(* 	com.iig.gcp.login.service.*.*(..))")
   	public void beforeLoginService(JoinPoint joinPoint){
   		logger.info(" Started Excution " + joinPoint.getSignature());
   		logger.info(" Completed Execution" +  joinPoint.getSignature());
   	}
	
	
	/*@Pointcut("execution(* 	com.iig.gcp.login.service.*.*(..))")
	public void dataLayerExecution(){}
	
	@Pointcut("execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))")
	public void businessLayerExecution(){}
	
	
   @Around("com.juniper.aspects.AuditAspect.dataLayerExecution()") 
   public void doAudit(ProceedingJoinPoint joinPoint) throws Throwable {

    System.out.println(joinPoint.getSignature().getName()); //get method name
    System.out.println(Arrays.toString(joinPoint.getArgs())); //get the arguments/params

    logger.info(" Check for user access ");
	logger.info(" Allowed execution for {}", joinPoint);
		
    joinPoint.proceed(); //continue 

    System.out.println("intercept response ");

   }
   
   	
   	@Before("com.juniper.aspects.AuditAspect.dataLayerExecution()")
   	public void before(JoinPoint joinPoint){
   		//Advice
   		logger.info(" Check for user access ");
   		logger.info(" Allowed execution for {}", joinPoint);
   	}
   
   	
   	
   	@Around("com.juniper.aspects.AuditAspect.dataLayerExecution()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
	}
   	
   	
   	@AfterReturning(value = "com.juniper.aspects.AuditAspect.dataLayerExecution()", 
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} returned with value {}", joinPoint, result);
	}
	
	@After(value = "com.juniper.aspects.AuditAspect.dataLayerExecution()")
	public void after(JoinPoint joinPoint) {
		logger.info("after execution of {}", joinPoint);
	}
	
	@AfterThrowing(pointcut="com.juniper.aspects.AuditAspect.dataLayerExecution() ",throwing = "ex")
    public void doRecoveryActions(JoinPoint joinPoint, Throwable ex) {

        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String stuff = signature.toString();
        String arguments = Arrays.toString(joinPoint.getArgs());
        logger.error("Write something in the log... We have caught exception in method: "
                + methodName + " with arguments "
                + arguments + "\nand the full toString: " + stuff + "\nthe exception is: "
                + ex.getMessage());
    }*/

}