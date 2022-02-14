package openk;

public class Eleve {

	private int num_eleve;

	public Eleve(int num_eleve) {
		super();
		this.num_eleve = num_eleve;
	}

	public void setNumero(int numero) {
		this.num_eleve= numero;
		
	}

	public int getNum_eleve() {
		return num_eleve;
	}

	
	@Override
	public String toString() {
		return "Eleve [num_eleve=" + num_eleve + "]";
	}
	
}
