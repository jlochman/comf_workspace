package cz.jlochman.comfigo.core.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileService {

	public String getMD5(File file);

	public String getFileExtension(String fileName);

	public void saveListToFile(List<String> list, String path) throws IOException;

}
