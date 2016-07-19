package sample1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// @Aspect는 횡단관심사항이 구현된 클래스를 표시
//  - springContainer는 등록된 Bean들 중에서 @Aspect가 annotated된 Bean을 찾아서 AOP구현에 참조한다.
//  - Target객체에 적용할 공통기능이 구현되어 있어야 한다.
//  - 공통기능이 언제 실행되게 할 것인지를 정의해야 한다.
//  - 공통기능을 어디에 적용할지를 정의해야 한다.
@Aspect
@Component
public class LoggingAdvice {

	/*
	 * when : @Before
	 * where : "excution(* sample1.*Service.*(..))"
	 * what : 구현코드
	 */
	
	/*
	 * "execution(* sample1.*Service.*(..))"
	 * 	- 리턴타입은 상관없다.
	 * 	- 적용대상은 sample1 패키지 안의 Service로 끝나는 이름의 모든 클래스나 인터페이스
	 * 	- 적용메서드는 모든 메서드다.
	 */
	/*
	@Before("execution(* sample1.*Service.*(..))")
	public void log() {
		// 공통기능 구현하기
		System.out.println("공통기능이 실행 중입니다.");
	}*/
	/* JoinPoint
	 * 	- 공통기능을 구현한 메서드에서는 적용대상이 되는 곳의 정보를 전달받는다.
	 *  - JoinPoint객체를 전달받을 수 있다.
	 *  - JointPost객체에는 대상객체, 대상메서드, 대상메서드의 매개변수 등의 정보를 조회할 수 있는 API
	 */
	/*
	@Before("execution(* sample1.*Service.*(..))")
	public void log(JoinPoint jp) {
		// 공통기능 구현하기
		System.out.println("공통기능이 실행 중입니다.");
		Object target = jp.getTarget();	// 대상 객체 조회
		Signature signature = jp.getSignature();	// 대상 메서드
		Object[] args = jp.getArgs();	// 매개변수
		
		String targetClassName = target.getClass().getName();
		String targetMethodName = signature.getName();
		
		System.out.println("["+targetClassName+"] " +targetMethodName+" is running.");
	}*/
	//@Before("within(sample1.*ServiceImpl)")
	//@Before("execution(* sample1.*Service.*(..)) && args(detail, accountType)")
	@Before("execution(* sample1.*Service.*(..)) && args(detail, ..)")
	public void log(JoinPoint jp, AccountDetail detail){
		String methodInfo = jp.getSignature().getName();
		System.out.println(methodInfo + " is running");
		
		System.out.println("예금주 : " + detail.getOwner());
	}
	
	
}
