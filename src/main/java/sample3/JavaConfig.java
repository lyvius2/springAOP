package sample3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@Component
@EnableAspectJAutoProxy
public class JavaConfig {

	@Bean
	public FileService file(){
		return new FileServiceImpl();
	}
	
	@Bean
	public RunningTimeCheckAdvice aspect(){
		return new RunningTimeCheckAdvice();
	}
}
