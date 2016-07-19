package sample3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

// @Component�� Annotated�ϸ� ��� Scan ���, @Service�� ����Ͻ� ������ �����ϴ� Ŭ������ �ַ� ���
@Service
public class FileServiceImpl implements FileService {

	public String readFile(String directory, String name) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("���� �б� �۾� ����");
		
		String text = null;
		
		File file = new File(directory, name);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		text = reader.readLine();
		
		reader.close();
		
		System.out.println("���� �б� �۾� ����");
		return text;
	}
}
