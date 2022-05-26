package openk;

public class Eleve {

	private int numEleve;
	private int numMatiere;
	private int note;

	public Eleve(int id) {
		super();
		this.numEleve = id;
	}


	public Eleve(int numEleve, int numMatiere, int note) {
		super();
		this.numEleve = numEleve;
		this.numMatiere = numMatiere;
		this.note = note;
	}

	public void setNumero(int numero) {
		this.numEleve= numero;
		
	}
	
	public int getNumMatiere() {
		return numMatiere;
	}

	public void setNumMatiere(int numMatiere) {
		this.numMatiere = numMatiere;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}
	
	public int getNumEleve() {
		return numEleve;
	}
	public void setNumEleve(int numEleve) {
		this.numEleve = numEleve;
	}
	@Override
	public String toString() {
		return "Eleve [numEleve=" + numEleve + ", numMatiere=" + numMatiere + ", note=" + note + "]";
	}
}
