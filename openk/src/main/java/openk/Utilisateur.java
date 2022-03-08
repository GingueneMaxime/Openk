package openk;

public class Utilisateur {

	private String nom;
	private String prenom;
	private String mail;
	private String tel;
	private String motDePasse;
	
	
	


	public Utilisateur(String nom, String prenom, String mail, String tel, String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.tel = tel;
		this.motDePasse = motDePasse;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", tel=" + tel + ", motDePasse="
				+ motDePasse + "]";
	}

	
	
	//finalisée
	
	
}
