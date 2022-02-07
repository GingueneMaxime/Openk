package openk;

public class Utilisateur {
	private int num_utilisateur;
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
		this.num_utilisateur = num_utilisateur;
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
		this.num_utilisateur = numero;
		
	}

	public int getNum_utilisateur() {
		return num_utilisateur;
	}
	@Override
	public String toString() {
		return "Utilisateur [num_utilisateur=" + num_utilisateur
				+ ", nom=" + nom + ", prenom=" +
				prenom + ", mail=" +
				mail + ", tel=" +
				tel +"]";
	}
}