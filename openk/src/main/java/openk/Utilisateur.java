package openk;

public class Utilisateur {
	private int numUtilisateur;
	private String nom;
	private String prenom;
	private String mail;
	private int tel;
	
	
	public Utilisateur( String nom, String prenom, String mail, int tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.tel = tel;
	}
	public Utilisateur(int id, String nom, String prenom, String mail, int tel) {
		this(nom,prenom,mail,tel);
		this.numUtilisateur = numUtilisateur;
		}
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getMail() {
		return mail;
	}

	public int getTel() {
		return tel;
	}

	public void setNumero(int numero) {
		this.numUtilisateur = numero;
		
	}

	public int getNumUtilisateur() {
		return numUtilisateur;
	}
	@Override
	public String toString() {
		return "Utilisateur [num_utilisateur=" + numUtilisateur
				+ ", nom=" + nom + ", prenom=" +
				prenom + ", mail=" +
				mail + ", tel=" +
				tel +"]";
	}
}
