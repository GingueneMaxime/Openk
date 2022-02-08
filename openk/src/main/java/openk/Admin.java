package openk;

public class Admin {
	private int num_admin;
	
	public Admin(int id) {
		
		this.num_admin=num_admin;
	}
	public void setNumero(int numero) {
		this.num_admin= numero;
		
	}
	public int getNum_Admin() {
		return num_admin;
	}
	@Override
	public String toString() {
		return "Admin[num_admin=" + num_admin+"]";
	}
}
