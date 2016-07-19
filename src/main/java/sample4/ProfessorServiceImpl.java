package sample4;

import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	public void showInfo() {
		System.out.println("교수 기본정보를 출력합니다.");
	}

}
