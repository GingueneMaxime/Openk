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

	public void setNum_matiere(int num_matiere) {
		this.num_matiere = num_matiere;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Matiere [num_matiere=" + num_matiere + ", nom=" + nom + "]";
	}
	
}
