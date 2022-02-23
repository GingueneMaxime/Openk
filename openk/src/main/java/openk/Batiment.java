package openk;

public class Batiment {
	private int numBatiment;
	private String nom;
	private String adresse;
	
	public Batiment(int numBatiment, String nom, String adresse) {
		super();
		this.numBatiment = numBatiment;
		this.nom = nom;
		this.adresse = adresse;
	}

	public int getNumBatiment() {
		return numBatiment;
	}

	public void setNumero(int numero) {
		this.numBatiment = numero;
	}

	public String getNom() {
		return nom;
	}

	public String getAdresse() {
		return adresse;
	}

	@Override
	public String toString() {
		return "Batiment [numBatiment=" + numBatiment + ", nom=" + nom + ", adresse=" + adresse + "]";
	}

	
	
	

}
