package sample4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAspect {

	/*
	 * @DeclareParents
	 * 		value에는 새로운 구현을 추가할 대상 클래스를 지정한다.('+'는 하위 클래스에도 적용을 의미)
	 * 		defaultImpl에는 새롭게 추가할 기능이 구현된 클래스를 지정한다.
	 */
	@DeclareParents(value="sample4.StudentService+ || sample4.ProfessorService+",
			defaultImpl=sample4.AdditionalDetailServiceImpl.class)
	public AdditionalDetailService additionalDetailService;
}
