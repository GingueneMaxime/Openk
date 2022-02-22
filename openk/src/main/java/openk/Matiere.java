package openk;

public class Matiere {

	private int numMatiere;
	private String nom;

	public Matiere(int numMatiere, String nom) {
		super();
		this.numMatiere = numMatiere;
		this.nom = nom;
	}

	public int getNumMatiere() {
		return numMatiere;
	}

	public void setNumero(int numero) {
		this.numMatiere = numero;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Matiere [num_matiere=" + numMatiere + ", nom=" + nom + "]";
	}
	
}
