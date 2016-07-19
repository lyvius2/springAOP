package sample4;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

	public void showInfo() {
		System.out.println("기본 정보를 출력합니다.");
	}

}
