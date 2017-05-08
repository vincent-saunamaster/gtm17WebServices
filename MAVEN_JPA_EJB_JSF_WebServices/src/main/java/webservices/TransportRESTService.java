package webservices;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.Cargaison;
import metier.CargaisonAerienne;
import metier.CargaisonRoutiere;
import metier.Marchandise;
import service.IServiceLocal;

@Path("/TWSREST")
public class TransportRESTService {

	@EJB
	private IServiceLocal serv;

	@POST
	@Path("addCargaison/{distance}/{dateLivraison}/{temperatureConservation}/{poidsMax}")
	public void addCargaison(@PathParam("distance") int distance, @PathParam("dateLivraison") String dateLivraison, @PathParam("temperatureConservation") double temperatureConservation,  @PathParam("poidsMax") double poidsMax) {
		// TODO Auto-generated method stub
		
		if(temperatureConservation != 0){
			
			CargaisonRoutiere c = new CargaisonRoutiere();
			c.setTemperatureConservation(temperatureConservation);
			c.setDistance(distance);
			c.setDateLivraison(new Date());
			serv.addCargaison(c);
		}
		if(poidsMax != 0){
			
			CargaisonAerienne c = new CargaisonAerienne();
			c.setPoidsMax(poidsMax);
			c.setDistance(distance);
			c.setDateLivraison(new Date());
			serv.addCargaison(c);
		}
	}

	@POST
	@Path("/addMarchandise/{nom}/{poids}/{volume}/{refCarg}")
	public void addMarchandise(@PathParam("nom") String nom, @PathParam("poids") double poids, @PathParam("volume") double volume, @PathParam("refCarg") long refCarg) {
		// TODO Auto-generated method stub
		
		Marchandise m = new Marchandise();
		m.setNom(nom);
		m.setPoids(poids);
		m.setVolume(volume);
		
		serv.addMarchandise(m, refCarg);
	}

	@GET
	@Path("/getAllCargaison")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cargaison> getAllCargaison() {
		// TODO Auto-generated method stub
		return serv.getAllCargaison();
	}

	@GET
	@Path("/getMarchandiseByMC/{mc}")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Marchandise> getMarchandiseByMC(@PathParam("mc") String mc) {
		// TODO Auto-generated method stub
		return serv.getMarchandiseByMC(mc);
	}

	@DELETE
	@Path("/deleteMarchandise/{}")
	public void deleteMarchandise(@PathParam("refMarchandise") long refMarchandise) {
		// TODO Auto-generated method stub
		serv.deleteMarchandise(refMarchandise);
	}
}
