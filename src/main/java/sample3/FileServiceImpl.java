package sample3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

// @Component를 Annotated하면 모두 Scan 대상, @Service는 비즈니스 로직을 수행하는 클래스에 주로 사용
@Service
public class FileServiceImpl implements FileService {

	public String readFile(String directory, String name) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("파일 읽기 작업 시작");
		
		String text = null;
		
		File file = new File(directory, name);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		text = reader.readLine();
		
		reader.close();
		
		System.out.println("파일 읽기 작업 종료");
		return text;
	}
}
