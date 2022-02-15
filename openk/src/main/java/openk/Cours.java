package openk;

import java.time.LocalDateTime;

public class Cours {
	private int num_cours;
	private int num_prof;
	private int num_matiere;
	private int num_promotion;
	private LocalDateTime date_debut;
	private LocalDateTime date_fin;
	
	public Cours(int num_cours, int num_prof, int num_matiere, int num_promotion, LocalDateTime date_debut,
			LocalDateTime date_fin) {
		super();
		this.num_cours = num_cours;
		this.num_prof = num_prof;
		this.num_matiere = num_matiere;
		this.num_promotion = num_promotion;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public Cours(int id, String num_prof2, String num_matiere2, String num_promotion2, String date_debut2,
			String date_fin2) {
		// TODO Auto-generated constructor stub
	}
	public int getNum_cours() {
		return num_cours;
	}
	public void setNum_cours(int num_cours) {
		this.num_cours = num_cours;
	}
	public int getNum_prof() {
		return num_prof;
	}
	public int getNum_matiere() {
		return num_matiere;
	}
	public int getNum_promotion() {
		return num_promotion;
	}
	public LocalDateTime getDate_debut() {
		return date_debut;
	}
	public LocalDateTime getDate_fin() {
		return date_fin;
	}
	@Override
	public String toString() {
		return "Cours [num_cours=" + num_cours + ", num_prof=" + num_prof + ", num_matiere=" + num_matiere
				+ ", num_promotion=" + num_promotion + ", date_debut=" + date_debut + ", date_fin=" + date_fin + "]";
	}
	
	
	
	
	
}
