package sample1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// @Configuration : 어노테이션은 이 클래스가 Spring Bean 설정 정보를 포함하고 있다는 표시
@Configuration
// @ComponentScan : Spring Bean으로 자동 등록할 패키지 경로를 지정
//				  : 패키지 경로를 지정하지 않으면 이 클래스가 속해있는 패키지 및 그 하위 패키지에서 Bean들을 스캔한다.
@ComponentScan(basePackages={"sample1"})
// @EnableAspectJAutoProxy : Proxy객체를 생성해주는 AutoProxyCreator Bean 등록
@EnableAspectJAutoProxy
public class JavaConfig {

	
}
