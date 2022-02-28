package openk;

import java.time.LocalDateTime;

public class Cours {
	private int numCours;
	private int numProf;
	private int numMatiere;
	private int numPromotion;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	
	public Cours(int numCours, int numProf, int numMatiere, int numPromotion, LocalDateTime dateDebut,
			LocalDateTime dateFin) {
		super();
		this.numCours = numCours;
		this.numProf = numProf;
		this.numMatiere = numMatiere;
		this.numPromotion = numPromotion;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	public Cours(int id, String num_prof2, String num_matiere2, String num_promotion2, String date_debut2,
			String date_fin2) {
		// TODO Auto-generated constructor stub
	}
	public int getNumCours() {
		return numCours;
	}
	public void setNumCours(int numCours) {
		this.numCours = numCours;
	}
	public int getNumProf() {
		return numProf;
	}
	public int getNumMatiere() {
		return numMatiere;
	}
	public int getNumPromotion() {
		return numPromotion;
	}
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}
	public LocalDateTime getDateFin() {
		return dateFin;
	}
	@Override
	public String toString() {
		return "Cours [numCours=" + numCours + ", numProf=" + numProf + ", numMatiere=" + numMatiere
				+ ", numPromotion=" + numPromotion + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
	
	
	
	
	
}
