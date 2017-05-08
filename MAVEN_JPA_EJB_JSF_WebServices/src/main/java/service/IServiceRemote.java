package service;

import java.util.List;

import metier.Cargaison;
import metier.Marchandise;

public interface IServiceRemote {

	public void addCargaison(Cargaison c);

	public void addMarchandise(Marchandise m, long refCarg);

	public List<Cargaison> getAllCargaison();

	public List<Marchandise> getMarchandiseByMC(String mc);

	public void deleteMarchandise(long refMarchandise);
}
