//Arik Regev

package server_side;

public class Vertix {
	private int id;
	
	public Vertix(int nID) {
		this.id = nID;
	}

	public int getId() {
		return id;
	}
	@Override
	public boolean equals(Object other) {
		return other.getClass().equals(getClass()) && id == ((Vertix) other).getId();
	}
	@Override
	public int hashCode() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return String.valueOf(getId());
	}
}
