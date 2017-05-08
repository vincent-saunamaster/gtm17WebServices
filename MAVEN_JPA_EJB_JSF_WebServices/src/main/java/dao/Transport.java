package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.Cargaison;
import metier.Marchandise;

@Stateless
public class Transport implements ITransportLocal, ITransportRemote {

	@PersistenceContext(name = "TPEJBWS-Pu")
	private EntityManager em;

	@Override
	public void addCargaison(Cargaison c) {
		// TODO Auto-generated method stub
		em.merge(c);
	}

	@Override
	public void addMarchandise(Marchandise m, long refCarg) {
		// TODO Auto-generated method stub
		m.setCargaison(em.find(Cargaison.class, refCarg));
		em.merge(m);
	}

	@Override
	public List<Cargaison> getAllCargaison() {
		// TODO Auto-generated method stub
		return (List<Cargaison>) em.createQuery("SELECT c FROM Cargaison c").getResultList();
	}

	@Override
	public List<Marchandise> getMarchandiseByMC(String mc) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT m FROM Marchandise m WHERE m.nom LIKE :etiquette");
		q.setParameter("etiquette", "%"+mc+"%");
		List<Marchandise> lm = (List<Marchandise>) q.getResultList(); 
		return lm;

	}

	@Override
	public void deleteMarchandise(long refMarchandise) {
		// TODO Auto-generated method stub
		em.remove(em.find(Marchandise.class, refMarchandise));
	}

}
