package openk;

public class Salle {
	
	private int num_salle;
	private int num_batiment;
	private String nom;
	private String equipement_virtuel;
	private int nb_places;
	
	public Salle(int num_salle, int num_batiment, String nom, String equipement_virtuel, int nb_places) {
		super();
		this.num_salle = num_salle;
		this.num_batiment = num_batiment;
		this.nom = nom;
		this.equipement_virtuel = equipement_virtuel;
		this.nb_places = nb_places;
	}
	public int getNum_salle() {
		return num_salle;
	}
	public void setNum_salle(int num_salle) {
		this.num_salle = num_salle;
	}
	public int getNum_batiment() {
		return num_batiment;
	}
	public String getNom() {
		return nom;
	}
	public String getEquipement_virtuel() {
		return equipement_virtuel;
	}
	public int getNb_places() {
		return nb_places;
	}
	@Override
	public String toString() {
		return "Salle [num_salle=" + num_salle + ", num_batiment=" + num_batiment + ", nom=" + nom
				+ ", equipement_virtuel=" + equipement_virtuel + ", nb_places=" + nb_places + "]";
	}
	
	
	
}
