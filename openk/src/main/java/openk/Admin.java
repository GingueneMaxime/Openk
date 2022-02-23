package openk;

public class Admin {
	private int numAdmin;
	
	public Admin(int id) {
		super();
		this.numAdmin=id;
	}
	public void setNumero(int numero) {
		this.numAdmin= numero;
		
	}
	public int getNumAdmin() {
		return numAdmin;
	}
	@Override
	public String toString() {
		return "Admin[numAdmin=" + numAdmin+"]";
	}
}
