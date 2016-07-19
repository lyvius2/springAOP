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
		System.out.println("before �����");
		System.out.println("args x["+x+"] y["+y+"]");
	}
	
	/*
	 * AfterReturning�� ��� �޼����� ������ ����� �� ����Ǵ� �������� �����Ѵ�.
	 * AfterReturning���� ������ �����ɿ����� ��� �޼����� ���� �� ��ȯ���� ��ȸ�� �� �ִ�.
	 * returning="��� �޼����� ��ȯ���� ���ε� ��ų ����"
	 */
	@AfterReturning(value="mypointcut()", returning="ret")
	public void afterReturningAdvice(JoinPoint jp, int ret) {
		System.out.println("afterReturning �����̽� ���� ��");
		System.out.println("��� �޼����� ��ȯ��: " + ret);
	}
	
	@After(value="mypointcut()")
	public void afterAdvice() {
		System.out.println("after �����̽� ���� ��");
	}
	
	/*
	 * @AfterThrowing�� ��� �޼��尡 ���� �� ������ �߻����� �� ������ �������� �����ϰ� �ȴ�.
	 * �ַ� ���ܹ߻� �� ���ܿ� ���� ����� ������ ����ϰų�,
	 * �߻��� ���ܸ� ������ ����� ���� ���� ��ü�� ��ȯ�ϴ� �۾��� �����Ѵ�.
	 * throwing="��� �޼��忡�� �߻�ȯ ���ܰ�ü�� ���ε� ��ų �̸�"
	 */
	@AfterThrowing(value="mypointcut()", throwing="ex")
	public void afterThrowingAdvice(JoinPoint jp, Exception ex) {
		System.out.println("afterThrowing ���� ��");
		System.err.println(ex.getMessage());
		ex.printStackTrace();
		
	}
}
