package sample2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SampleAdvice {
	
	@Pointcut("execution(* sample2.*Service.*(..))")
	public void mypointcut(){}
	
	@Pointcut("execution(* sample2.*Service.*(..))")
	public void yourpointcut(){}
	
	//@Before(value="mypointcut() && yourpointcut()")
	@Before(value="mypointcut() && args(x,y)", argNames="jp,x,y")
	public void beforeAdvice(JoinPoint jp, int x, int y){
		System.out.println("before 실행됨");
		System.out.println("args x["+x+"] y["+y+"]");
	}
	
	/*
	 * AfterReturning은 대상 메서드의 실행이 종료될 때 실행되는 공통기능을 정의한다.
	 * AfterReturning으로 지정된 공통기능에서는 대상 메서드의 실행 후 반환값을 조회할 수 있다.
	 * returning="대상 메서드의 반환값을 바인딩 시킬 이흠"
	 */
	@AfterReturning(value="mypointcut()", returning="ret")
	public void afterReturningAdvice(JoinPoint jp, int ret) {
		System.out.println("afterReturning 어드바이스 실행 됨");
		System.out.println("대상 메서드의 반환값: " + ret);
	}
	
	@After(value="mypointcut()")
	public void afterAdvice() {
		System.out.println("after 어드바이스 실행 됨");
	}
	
	/*
	 * @AfterThrowing은 대상 메서드가 실행 중 오류가 발생했을 때 실행할 공통기능을 지정하게 된다.
	 * 주로 예외발생 시 예외에 대한 디버깅 정보를 출력하거나,
	 * 발생된 예외를 적절한 사용자 정의 예외 객체로 변환하는 작업을 수행한다.
	 * throwing="대상 메서드에서 발생환 예외객체를 바인딩 시킬 이름"
	 */
	@AfterThrowing(value="mypointcut()", throwing="ex")
	public void afterThrowingAdvice(JoinPoint jp, Exception ex) {
		System.out.println("afterThrowing 실행 됨");
		System.err.println(ex.getMessage());
		ex.printStackTrace();
		
	}
}
