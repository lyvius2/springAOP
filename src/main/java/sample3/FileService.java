package sample3;

import java.io.IOException;

public interface FileService {

	String readFile(String directory, String name) throws IOException;
}
