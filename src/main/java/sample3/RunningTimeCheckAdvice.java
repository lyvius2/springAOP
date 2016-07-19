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
	
	// @Around�� ProceedingJoinPoint�� �ݵ�� �ʿ��ϴ�.
	@Around("mypointcut()")
	public Object timeCheck(ProceedingJoinPoint jp) throws Throwable {
		Object returnValue = null;
		
		// ��� �޼��� ���� �� �ڵ�
		System.out.println("around�� ��ó���۾� ����");
		StopWatch watch = new StopWatch();
		watch.start();
		
		// ��� �޼��带 �����ϴ� �ڵ�
		returnValue = jp.proceed();
		
		// ��� �޼��� ���� �� �ڵ�
		System.out.println("around�� ��ó���۾� ����");
		watch.stop();
		System.out.println(watch.getTotalTimeMillis() + "�и��� �ҿ�");
		
		return returnValue;
	}
}
