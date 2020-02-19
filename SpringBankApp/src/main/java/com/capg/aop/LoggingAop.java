
package com.capg.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAop {

	Logger logger = LoggerFactory.getLogger(LoggingAop.class);

	// setup pointcut declaration
	@Pointcut("execution(* com.capg.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.capg.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.capg.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {

		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		logger.info("===> in @Before calling method: " + theMethod);

		// display the arguments to the method

		// get the arguments
		Object[] args = theJoinPoint.getArgs();

		// loop and display args
		for (Object tempArg : args) {
			logger.info("====> argument: " + tempArg);
		}

	}

	// add @After returning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afteReturning(JoinPoint theJoinPoint, Object theResult) {
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		logger.info("===> in @AfterReturning from method: " + theMethod);

		// display the data
		logger.info("===> result: " + theResult);

	}

	/*
	 * @AfterThrowing("execution(* com.capg.service.IAccountServiceImpl.*(..))")
	 * public void logAfterThrowingAllMethoods(InsufficientBalanceException ex) {
	 * logger.error(ex.getMessage()); }
	 * 
	 * @AfterThrowing("execution(* com.capg.service.IAccountServiceImpl.*(..))")
	 * public void logAfterThrowingAllMethoods(InvalidPhoneNumberException ex) {
	 * logger.error(ex.getMessage()); }
	 */

	/*
	 * @AfterThrowing(pointcut = "execution(* com.capg.service.*.*(..))", throwing =
	 * "ex") public void logAfterThrowingAllMethoods(UserExistsException ex) {
	 * logger.error(ex.getMessage()); }
	 * 
	 * @AfterThrowing(pointcut = "execution(* com.capg.service.*.*(..))", throwing =
	 * "ex") public void logAfterThrowingAllMethoods(UserNotFoundException ex) {
	 * logger.error(ex.getMessage()); }
	 * 
	 * @AfterThrowing(pointcut = "execution(* com.capg.service.*.*(..))", throwing =
	 * "ex") public void logAfterThrowingAllMethoods(InvalidTrainNoException ex) {
	 * logger.error(ex.getMessage()); }
	 * 
	 * @AfterThrowing(pointcut = "execution(* com.capg.service.*.*(..))", throwing =
	 * "ex") public void logAfterThrowingAllMethoods(NoTrainsFoundException ex) {
	 * logger.error(ex.getMessage()); }
	 * 
	 * @AfterThrowing(pointcut = "execution(* com.capg.service.*.*(..))", throwing =
	 * "ex") public void logAfterThrowingAllMethoods(InvalidPnrException ex) {
	 * logger.error(ex.getMessage()); }
	 * 
	 * @AfterThrowing(pointcut = "execution(* com.capg.service.*.*(..))", throwing =
	 * "ex") public void logAfterThrowingAllMethoods(SeatUnAvailabiltyException ex)
	 * { logger.error(ex.getMessage()); }
	 */}
