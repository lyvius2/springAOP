package sample1;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BankAccountApp {

	public static void main(String[] args){
		/*
		ApplicationContext context = new GenericXmlApplicationContext("classpath:/sample1/context.xml");
		*/
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// BackAccountService류의 객체를 검색했다.
		// Interface 타입의 변수로 받아야 한다. -> Spring은 Proxy 객체를 바라보기 때문
		BankAccountService service = context.getBean(BankAccountService.class);
		
		AccountDetail detail = new AccountDetail();
		detail.setOwner("홍길동");
		detail.setBalanceAmount(1000000);
		detail.setLastTransactionTime(new Date());
		
		service.createAccount(detail, "입금");
		
		service.deleteAccount(detail);
		
	}
}
