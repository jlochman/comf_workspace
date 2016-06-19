package cz.jlochman.comfigo.core.services.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;

import cz.jlochman.comfigo.core.ServiceLocator;
import cz.jlochman.comfigo.core.DAO.ImageDAO;
import cz.jlochman.comfigo.core.entityDomain.Image;
import cz.jlochman.comfigo.core.services.ImageService;

public class ImageServiceImpl implements ImageService {

	private final static String IMG_FILE_PATH = "/Users/jlochman/Documents/Comfigo/webData/images/";
	private ImageDAO imgDAO = ServiceLocator.getInstance().getDaos().getImageDAO();

	public Image getImageFromURL(String url) {
		Image image = new Image();
		String extension = ServiceLocator.getInstance().getFileService().getFileExtension(url);

		try {
			System.out.println("downloading tmp file");
			File tmpFile = new File(IMG_FILE_PATH + "tmp" + extension);
			FileUtils.copyURLToFile(new URL(url), tmpFile);
			String md5 = ServiceLocator.getInstance().getFileService().getMD5(tmpFile);

			File destFile = new File(IMG_FILE_PATH + md5 + extension);
			FileUtils.copyFile(tmpFile, destFile);
			tmpFile.delete();

			image.setPath(IMG_FILE_PATH + md5 + extension);
			image.setMd5(md5);
			image.setUrl(url);
		} catch (IOException e) {
			System.err.println("IOException durring downloading img file from url: " + url);
			e.printStackTrace();
		}

		return image;
	}

	public List<Image> getAllImages() {
		return imgDAO.getAllImages();
	}

}
