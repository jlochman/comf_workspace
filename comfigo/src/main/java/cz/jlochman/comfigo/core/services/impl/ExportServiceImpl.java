package cz.jlochman.comfigo.core.services.impl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import cz.jlochman.comfigo.core.ServiceLocator;
import cz.jlochman.comfigo.core.entityDomain.Image;
import cz.jlochman.comfigo.core.entityDomain.Parameter;
import cz.jlochman.comfigo.core.entityDomain.Product;
import cz.jlochman.comfigo.core.services.ExportService;
import cz.jlochman.comfigo.core.services.FileService;
import cz.jlochman.comfigo.core.services.ProductService;

public class ExportServiceImpl implements ExportService {

	private final static String EXPORT_DIR_PATH = "/Users/jlochman/Documents/Comfigo/webData/export/";
	private final static String TXT_NAME = "info.txt";

	private ProductService productService = ServiceLocator.getInstance().getProductService();
	private FileService fileService = ServiceLocator.getInstance().getFileService();

	public void exportDownDate(Date downDate) {
		System.out.println("export for date " + downDate.toString());

		List<Product> products = productService.getProductsForDownDate(downDate);
		for (Product product : products) {
			System.out.println(product.getName());
			exportProduct(product);
		}
	}

	private String formatDateToString(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	private void exportProduct(Product product) {
		String exportDir = EXPORT_DIR_PATH + formatDateToString(product.getDownloadDate()) + File.separator
				+ productService.getNormalizedName(product) + File.separator;

		File myDir = new File(exportDir);
		if (!myDir.exists()) {
			myDir.mkdirs();
		}

		List<String> txtList = new ArrayList<String>();
		txtList.add("Name:");
		txtList.add(product.getName());
		txtList.add("");
		txtList.add("Description:");
		txtList.add(product.getDescription());
		txtList.add("");
		List<Parameter> params = product.getParameters();
		for (Parameter parameter : params) {
			txtList.add(parameter.getName() + ":");
			txtList.add(parameter.getValue());
		}
		try {
			fileService.saveListToFile(txtList, exportDir + TXT_NAME);
		} catch (IOException e) {
			System.err.println("IOException while writing file: " + exportDir + TXT_NAME);
			e.printStackTrace();
		}

		List<Image> images = product.getImages();
		if (!(images == null || images.isEmpty())) {
			for (int i = 0; i < images.size(); i++) {
				System.out.println("... cp figure " + (i + 1));
				Image img = images.get(i);
				String imgCopyPath = exportDir + Integer.toString(i + 1) + fileService.getFileExtension(img.getPath());
				File srcFile = new File(img.getPath());
				File destFile = new File(imgCopyPath);
				try {
					FileUtils.copyFile(srcFile, destFile);
				} catch (IOException e) {
					System.err.println("IOException durring file copy. Source: " + srcFile.getAbsolutePath()
							+ ", Destintation: " + destFile.getAbsolutePath());
					e.printStackTrace();
				}
			}
		}

	}

}
