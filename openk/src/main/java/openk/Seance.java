package openk;

import java.time.LocalDateTime;

public class Seance {

	private int num_seance;
	private int num_cours;
	private int num_salle;
	private LocalDateTime date_debut;
	private LocalDateTime date_fin;
	
	public Seance(int num_seance, int num_cours, int num_salle, LocalDateTime date_debut, LocalDateTime date_fin) {
		super();
		this.num_seance = num_seance;
		this.num_cours = num_cours;
		this.num_salle = num_salle;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public Seance(int id, String num_salle2, String date_debut2, String date_fin2) {
		// TODO Auto-generated constructor stub
	}
	public int getNum_seance() {
		return num_seance;
	}
	public void setNum_seance(int num_seance) {
		this.num_seance = num_seance;
	}
	public int getNum_cours() {
		return num_cours;
	}
	public int getNum_salle() {
		return num_salle;
	}
	public LocalDateTime getDate_debut() {
		return date_debut;
	}
	public LocalDateTime getDate_fin() {
		return date_fin;
	}
	@Override
	public String toString() {
		return "Seance [num_seance=" + num_seance + ", num_cours=" + num_cours + ", num_salle=" + num_salle
				+ ", date_debut=" + date_debut + ", date_fin=" + date_fin + "]";
	}
	
	
	
	
}
