package openk;

public class Appartenance {
	private int num_eleve;
	private int num_promotion;

	
	
	public Appartenance(int id, int id2) {
		this.num_eleve = num_eleve;
		this.num_promotion = num_promotion;
		}
	
	public void setNumero(int numero) {
		this.num_eleve = numero;
		this.num_promotion= numero;
		
	}

	public int getNum_eleve() {
		return num_eleve;
	}
	public int getNum_promotion() {
		return num_promotion;
	}
	@Override
	public String toString() {
		return "Apartenance [num_eleve=" + num_eleve+ ", num_promotion=" + num_promotion+"  ]";
	}
}
