package openk;

public class Batiment {
	private int num_batiment;
	private String nom;
	private String adresse;
	
	public Batiment(int num_batiment, String nom, String adresse) {
		super();
		this.num_batiment = num_batiment;
		this.nom = nom;
		this.adresse = adresse;
	}

	public int getNum_batiment() {
		return num_batiment;
	}

	public void setNum_batiment(int num_batiment) {
		this.num_batiment = num_batiment;
	}

	public String getNom() {
		return nom;
	}

	public String getAdresse() {
		return adresse;
	}

	@Override
	public String toString() {
		return "Batiment [num_batiment=" + num_batiment + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
	
	
	

}
