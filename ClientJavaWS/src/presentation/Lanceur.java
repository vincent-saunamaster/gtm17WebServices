package presentation;

import java.util.List;

import ws.BanqueService;
import ws.BanqueWS;
import ws.Compte;

public class Lanceur {
	public static void main(String[] args) {

		BanqueService banqueService = new BanqueWS().getBanqueServicePort();

		System.out.println("Conversion");
		banqueService.conversionED(100);
		System.out.println("Consulter un compte");
		Compte c = banqueService.getCompte(10);
		System.out.println(c);
		System.out.println("Lister les comptes");
		List<Compte> l = banqueService.getComptes();
		for (Compte compte : l) {
			System.out.println(compte.toString());
		}
	}
}
