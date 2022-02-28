package openk;

public class Utilisateur {
	private int numUtilisateur;
	private String nom;
	private String prenom;
	private String mail;
	private String tel;
	private String motDePasse;
	
	
	public Utilisateur( String nom, String prenom, String mail, String tel,String motDePasse ) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.tel = tel;
		this.motDePasse=motDePasse;
	}
	public Utilisateur(int id, String nom, String prenom, String mail, String tel, String motDePasse) {
		this(nom,prenom,mail,tel,motDePasse);
		this.numUtilisateur = id;
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

	public String getTel() {
		return tel;
	}
	public String getmotDePasse() {
		return motDePasse;
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
				tel +", motDePasse="+ motDePasse+"]";
	}
	public void setNom(String nom) {
		this.nom=nom;	
	}
	public void setTelephone(String telephone) {
		this.tel=telephone;
		
	}
}
