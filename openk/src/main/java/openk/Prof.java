package openk;

public class Prof {

	private int num_prof;

	public Prof(int num_prof) {
		super();
		this.num_prof = num_prof;
	}

	public int getNum_prof() {
		return num_prof;
	}

	public void setNum_prof(int num_prof) {
		this.num_prof = num_prof;
	}

	@Override
	public String toString() {
		return "Prof [num_prof=" + num_prof + "]";
	}
	
}
