package cz.jlochman.comfigo.core.services;

import java.io.File;

public interface FileService {

	public String getMD5(File file);
	public String getFileExtension(String fileName);
	
}
