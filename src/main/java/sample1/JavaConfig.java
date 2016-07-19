package sample1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// @Configuration : ������̼��� �� Ŭ������ Spring Bean ���� ������ �����ϰ� �ִٴ� ǥ��
@Configuration
// @ComponentScan : Spring Bean���� �ڵ� ����� ��Ű�� ��θ� ����
//				  : ��Ű�� ��θ� �������� ������ �� Ŭ������ �����ִ� ��Ű�� �� �� ���� ��Ű������ Bean���� ��ĵ�Ѵ�.
@ComponentScan(basePackages={"sample1"})
// @EnableAspectJAutoProxy : Proxy��ü�� �������ִ� AutoProxyCreator Bean ���
@EnableAspectJAutoProxy
public class JavaConfig {

	
}
