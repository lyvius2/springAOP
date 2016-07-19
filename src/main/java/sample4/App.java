package sample4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		StudentService service = context.getBean(StudentService.class);
		ProfessorService service2 = context.getBean(ProfessorService.class);
		
		service.showInfo();
		((AdditionalDetailService)service).showDetail();
		
		service2.showInfo();
		((AdditionalDetailService)service2).showDetail();
	}
}
