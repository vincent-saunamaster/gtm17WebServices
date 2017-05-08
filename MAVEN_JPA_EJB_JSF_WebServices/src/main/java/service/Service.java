package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.ITransportLocal;
import metier.Cargaison;
import metier.Marchandise;

@Stateless
public class Service implements IServiceLocal, IServiceRemote {

	@EJB
	private ITransportLocal dao;
	
	
	@Override
	public void addCargaison(Cargaison c) {
		// TODO Auto-generated method stub
		dao.addCargaison(c);
	}

	@Override
	public void addMarchandise(Marchandise m, long refCarg) {
		// TODO Auto-generated method stub
		dao.addMarchandise(m, refCarg);
	}

	@Override
	public List<Cargaison> getAllCargaison() {
		// TODO Auto-generated method stub
		return dao.getAllCargaison();
	}

	@Override
	public List<Marchandise> getMarchandiseByMC(String mc) {
		// TODO Auto-generated method stub
		return dao.getMarchandiseByMC(mc);
	}

	@Override
	public void deleteMarchandise(long refMarchandise) {
		// TODO Auto-generated method stub
		dao.deleteMarchandise(refMarchandise);
	}

}
