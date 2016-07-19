package sample3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class RunningTimeCheckAdvice {

	@Pointcut("within(sample3.FileServiceImpl)")
	public void mypointcut() {}
	
	// @Around은 ProceedingJoinPoint가 반드시 필요하다.
	@Around("mypointcut()")
	public Object timeCheck(ProceedingJoinPoint jp) throws Throwable {
		Object returnValue = null;
		
		// 대상 메서드 실행 전 코드
		System.out.println("around의 전처리작업 시작");
		StopWatch watch = new StopWatch();
		watch.start();
		
		// 대상 메서드를 실행하는 코드
		returnValue = jp.proceed();
		
		// 대상 메서드 실행 후 코드
		System.out.println("around의 후처리작업 시작");
		watch.stop();
		System.out.println(watch.getTotalTimeMillis() + "밀리초 소요");
		
		return returnValue;
	}
}
