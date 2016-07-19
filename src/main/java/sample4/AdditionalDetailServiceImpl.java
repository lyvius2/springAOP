package sample4;

import org.springframework.stereotype.Service;

@Service
public class AdditionalDetailServiceImpl implements AdditionalDetailService {

	public void showDetail() {
		System.out.println("상세정보 출력");
	}

}
