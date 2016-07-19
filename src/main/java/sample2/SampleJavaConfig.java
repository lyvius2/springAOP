package sample2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class SampleJavaConfig {

	@Bean
	public SampleService service(){
		return new SampleServiceImpl();
	}
	
	@Bean
	public SampleAdvice aspect(){
		return new SampleAdvice();
	}
}
