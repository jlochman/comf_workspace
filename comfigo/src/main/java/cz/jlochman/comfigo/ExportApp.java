package cz.jlochman.comfigo;

import cz.jlochman.comfigo.core.ServiceLocator;

public class ExportApp {

	private static ServiceLocator serviceLocator = ServiceLocator.getInstance();

	public static void main(String[] args) {
		System.out.println("Initializing services");
		serviceLocator.initializeService();
		System.out.println("Exporting");
		export();
		System.out.println("DONE");
	}

	private static void export() {
		serviceLocator.getExportService().exportDownDate(serviceLocator.getProductService().getLastDownDate());
	}

}
