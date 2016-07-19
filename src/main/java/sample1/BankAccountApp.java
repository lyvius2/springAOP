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
		
		// BackAccountService���� ��ü�� �˻��ߴ�.
		// Interface Ÿ���� ������ �޾ƾ� �Ѵ�. -> Spring�� Proxy ��ü�� �ٶ󺸱� ����
		BankAccountService service = context.getBean(BankAccountService.class);
		
		AccountDetail detail = new AccountDetail();
		detail.setOwner("ȫ�浿");
		detail.setBalanceAmount(1000000);
		detail.setLastTransactionTime(new Date());
		
		service.createAccount(detail, "�Ա�");
		
		service.deleteAccount(detail);
		
	}
}
