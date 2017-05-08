package ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.Compte;

@WebService(serviceName = "BanqueWS")
public class BanqueService {

	@WebMethod(operationName = "conversionED")
	public double conversionEuroDollar(@WebParam(name="mt") double montant) {
		return montant * 1.09d;
	}

	@WebMethod
	public Compte getCompte(@WebParam(name="code") int code) {
		Compte c = new Compte();
		c.setCode(code);
		c.setDateCreation(new Date());
		c.setSolde(10000);
		return c;
	}
	@WebMethod
	public List<Compte> getComptes() {

		// simulation d'une recherche de compte en BDD
		List<Compte> comptes = new ArrayList<Compte>();

		Compte c1 = new Compte();
		c1.setCode(2);
		c1.setSolde(2000);
		c1.setDateCreation(new Date());

		Compte c2 = new Compte();
		c2.setCode(3);
		c2.setSolde(3000);
		c2.setDateCreation(new Date());

		comptes.add(c1);
		comptes.add(c2);

		return comptes;
	}
}
