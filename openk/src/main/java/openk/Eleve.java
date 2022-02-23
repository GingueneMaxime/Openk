package openk;

public class Eleve {

	private int numEleve;

	public Eleve(int id) {
		super();
		this.numEleve = id;
	}

	public void setNumero(int numero) {
		this.numEleve= numero;
		
	}

	public int getNumEleve() {
		return numEleve;
	}

	
	@Override
	public String toString() {
		return "Eleve [numEleve=" + numEleve + "]";
	}
	
}
