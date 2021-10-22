package org.impelsys.SpringBootDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserServiceAspect {
	
	@Pointcut("execution(* org.impelsys.SpringBootDemo.dao.impl.UserDaoImpl.*(..))")
	public void userDaoMapping() {
		
	}
	//Advice--->what is the functionalitoes to be done/what actions to be taken
	@Before("userDaoMapping()")//PointCut
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("before method:"+joinPoint.getSignature());
		
	}
	//joinPoint-->it is point during the execution of the program
	@After("userDaoMapping()")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("before method:"+joinPoint.getSignature());
		
	}
}
