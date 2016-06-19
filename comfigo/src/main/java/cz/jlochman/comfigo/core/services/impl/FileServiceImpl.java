package cz.jlochman.comfigo.core.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import cz.jlochman.comfigo.core.services.FileService;

public class FileServiceImpl implements FileService {

	public String getMD5(File file) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			String md5 = DigestUtils.md5Hex(fis);
			fis.close();
			return md5;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getFileExtension(String fileName) {
		String extension = "";
		if (fileName.contains(".")) {
			extension = fileName.substring(fileName.lastIndexOf("."));
		}
		return extension;
	}

	public void saveListToFile(List<String> list, String path) throws IOException {
		Path file = Paths.get(path);
		Files.write(file, list, Charset.forName("UTF-8"));
	}

}
