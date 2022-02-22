package openk;

public class Formation {

	private int numFormation;
	private String nom;
	private String certifOuDiplome;
	
	public Formation(int numFormation, String nom, String certifOuDiplome) {
		super();
		this.numFormation = numFormation;
		this.nom = nom;
		this.certifOuDiplome = certifOuDiplome;
	}
	public int getNumFormation() {
		return numFormation;
	}
	public void setNumero(int numero) {
		this.numFormation = numero;
	}
	public String getNom() {
		return nom;
	}
	public String getCertifOuDiplome() {
		return certifOuDiplome;
	}
	@Override
	public String toString() {
		return "Formation [numFormation=" + numFormation + ", nom=" + nom + ", certifOuDiplome=" + certifOuDiplome
				+ "]";
	}
	
	
}
