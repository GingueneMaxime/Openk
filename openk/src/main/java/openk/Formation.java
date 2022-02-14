package openk;

public class Formation {

	private int num_formation;
	private String nom;
	private String certif_ou_diplome;
	
	public Formation(int num_formation, String nom, String certif_ou_diplome) {
		super();
		this.num_formation = num_formation;
		this.nom = nom;
		this.certif_ou_diplome = certif_ou_diplome;
	}
	public int getNum_formation() {
		return num_formation;
	}
	public void setNumero(int numero) {
		this.num_formation = numero;
	}
	public String getNom() {
		return nom;
	}
	public String getCertif_ou_diplome() {
		return certif_ou_diplome;
	}
	@Override
	public String toString() {
		return "Formation [num_formation=" + num_formation + ", nom=" + nom + ", certif_ou_diplome=" + certif_ou_diplome
				+ "]";
	}
	
	
}
