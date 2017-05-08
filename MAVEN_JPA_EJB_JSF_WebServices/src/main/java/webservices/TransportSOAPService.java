package webservices;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.Cargaison;
import metier.Marchandise;
import service.IServiceLocal;

@WebService(serviceName = "TWSSOAP")
public class TransportSOAPService {

	@EJB
	private IServiceLocal serv;

	@WebMethod
	public void addCargaison(@WebParam Cargaison c) {
		// TODO Auto-generated method stub
		serv.addCargaison(c);
	}

	@WebMethod
	public void addMarchandise(@WebParam Marchandise m, @WebParam long refCarg) {
		// TODO Auto-generated method stub
		serv.addMarchandise(m, refCarg);
	}

	@WebMethod
	public List<Cargaison> getAllCargaison() {
		// TODO Auto-generated method stub
		return serv.getAllCargaison();
	}

	@WebMethod
	public List<Marchandise> getMarchandiseByMC(@WebParam String mc) {
		// TODO Auto-generated method stub
		return serv.getMarchandiseByMC(mc);
	}

	@WebMethod
	public void deleteMarchandise(@WebParam long refMarchandise) {
		// TODO Auto-generated method stub
		serv.deleteMarchandise(refMarchandise);
	}
}
