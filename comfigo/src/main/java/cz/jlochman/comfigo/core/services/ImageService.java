package cz.jlochman.comfigo.core.services;

import java.util.List;

import cz.jlochman.comfigo.core.entityDomain.Image;

public interface ImageService {

	public List<Image> getAllImages();
	
	public Image getImageFromURL(String url);
	
}
