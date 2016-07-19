package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		FileService service = context.getBean(FileService.class);
		String text = service.readFile("C:/windows", "win.ini");
		System.out.println("Result : " + text);
	}
}
