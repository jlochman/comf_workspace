package cz.jlochman.comfigo.core.services.impl;

import java.io.File;
import java.io.FileInputStream;

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

}
