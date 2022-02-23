package openk;

public class Salle {
	
	private int numSalle;
	private int numBatiment;
	private String nom;
	private String equipementVirtuel;
	private int nbPlaces;
	
	public Salle(int numSalle, int numBatiment, String nom, String equipementVirtuel, int nbPlaces) {
		super();
		this.numSalle = numSalle;
		this.numBatiment = numBatiment;
		this.nom = nom;
		this.equipementVirtuel = equipementVirtuel;
		this.nbPlaces = nbPlaces;
	}
	public int getNumSalle() {
		return numSalle;
	}
	public void setNumero(int numero) {
		this.numSalle = numero;
	}
	public int getNumBatiment() {
		return numBatiment;
	}
	public String getNom() {
		return nom;
	}
	public String getEquipementVirtuel() {
		return equipementVirtuel;
	}
	public int getNbPlaces() {
		return nbPlaces;
	}
	@Override
	public String toString() {
		return "Salle [num_salle=" + numSalle + ", num_batiment=" + numBatiment + ", nom=" + nom
				+ ", equipement_virtuel=" + equipementVirtuel + ", nb_places=" + nbPlaces + "]";
	}
	
	
	
}
