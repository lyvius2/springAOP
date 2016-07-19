package sample1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// @Aspect�� Ⱦ�ܰ��ɻ����� ������ Ŭ������ ǥ��
//  - springContainer�� ��ϵ� Bean�� �߿��� @Aspect�� annotated�� Bean�� ã�Ƽ� AOP������ �����Ѵ�.
//  - Target��ü�� ������ �������� �����Ǿ� �־�� �Ѵ�.
//  - �������� ���� ����ǰ� �� �������� �����ؾ� �Ѵ�.
//  - �������� ��� ���������� �����ؾ� �Ѵ�.
@Aspect
@Component
public class LoggingAdvice {

	/*
	 * when : @Before
	 * where : "excution(* sample1.*Service.*(..))"
	 * what : �����ڵ�
	 */
	
	/*
	 * "execution(* sample1.*Service.*(..))"
	 * 	- ����Ÿ���� �������.
	 * 	- �������� sample1 ��Ű�� ���� Service�� ������ �̸��� ��� Ŭ������ �������̽�
	 * 	- ����޼���� ��� �޼����.
	 */
	/*
	@Before("execution(* sample1.*Service.*(..))")
	public void log() {
		// ������ �����ϱ�
		System.out.println("�������� ���� ���Դϴ�.");
	}*/
	/* JoinPoint
	 * 	- �������� ������ �޼��忡���� �������� �Ǵ� ���� ������ ���޹޴´�.
	 *  - JoinPoint��ü�� ���޹��� �� �ִ�.
	 *  - JointPost��ü���� ���ü, ���޼���, ���޼����� �Ű����� ���� ������ ��ȸ�� �� �ִ� API
	 */
	/*
	@Before("execution(* sample1.*Service.*(..))")
	public void log(JoinPoint jp) {
		// ������ �����ϱ�
		System.out.println("�������� ���� ���Դϴ�.");
		Object target = jp.getTarget();	// ��� ��ü ��ȸ
		Signature signature = jp.getSignature();	// ��� �޼���
		Object[] args = jp.getArgs();	// �Ű�����
		
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
		
		System.out.println("������ : " + detail.getOwner());
	}
	
	
}
