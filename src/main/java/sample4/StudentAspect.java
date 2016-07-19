package sample4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAspect {

	/*
	 * @DeclareParents
	 * 		value���� ���ο� ������ �߰��� ��� Ŭ������ �����Ѵ�.('+'�� ���� Ŭ�������� ������ �ǹ�)
	 * 		defaultImpl���� ���Ӱ� �߰��� ����� ������ Ŭ������ �����Ѵ�.
	 */
	@DeclareParents(value="sample4.StudentService+ || sample4.ProfessorService+",
			defaultImpl=sample4.AdditionalDetailServiceImpl.class)
	public AdditionalDetailService additionalDetailService;
}
