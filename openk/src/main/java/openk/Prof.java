package openk;

public class Prof {

	private int numProf;

	public Prof(int id) {
		super();
		this.numProf = id;
	}

	public int getNumProf() {
		return numProf;
	}

	public void setNumero(int numProf) {
		this.numProf = numProf;
	}

	@Override
	public String toString() {
		return "Prof [num_prof=" + numProf + "]";
	}
	
}
