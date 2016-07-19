package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SampleApp {

	public static void main(String[] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(SampleJavaConfig.class);
		
		SampleService service = context.getBean(SampleService.class);
		service.divide(8, 4);
		service.divide(7, 2);
		//service.divide(7, 0);
	}
}
