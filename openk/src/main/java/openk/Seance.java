package openk;

import java.time.LocalDateTime;

public class Seance {

	private int numSeance;
	private int numCours;
	private int numSalle;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	
	
	public Seance(int numSeance, int numCours, int numSalle, LocalDateTime dateDebut, LocalDateTime dateFin) {
		super();
		this.numSeance = numSeance;
		this.numCours = numCours;
		this.numSalle = numSalle;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}


	public int getNumSeance() {
		return numSeance;
	}
	public void setNumSeance(int numSeance) {
		this.numSeance = numSeance;
	}
	public int getNumCours() {
		return numCours;
	}
	public int getNumSalle() {
		return numSalle;
	}
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}
	public LocalDateTime getDateFin() {
		return dateFin;
	}
	@Override
	public String toString() {
		return "Seance [numSeance=" + numSeance + ", numCours=" + numCours + ", numSalle=" + numSalle
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
	
	//finalisée
	
	
}
