package openk;

public class Matiere {

	private int num_matiere;
	private String nom;

	public Matiere(int num_matiere, String nom) {
		super();
		this.num_matiere = num_matiere;
		this.nom = nom;
	}

	public int getNum_matiere() {
		return num_matiere;
	}

	public void setNumero(int numero) {
		this.num_matiere = numero;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Matiere [num_matiere=" + num_matiere + ", nom=" + nom + "]";
	}
	
}
