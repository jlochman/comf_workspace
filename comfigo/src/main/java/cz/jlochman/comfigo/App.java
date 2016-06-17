package cz.jlochman.comfigo;

import cz.jlochman.comfigo.core.ServiceLocator;

public class App {

	public static void main(String[] args) {
		ServiceLocator.getInstance().getDaos().getEntityManager();
		
		
		System.out.println("DONE");
	}
	
}
