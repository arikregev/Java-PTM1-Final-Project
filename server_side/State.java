//Arik Regev

package server_side;

public class State<T> {
	private T state;
	private int cost;
	private State<T> cameFrom;
	
	public State(T state) {
		this(state, 0, null);
	}
	public State(T state, int cost, State<T> cameFrom) {
		this.state = state;
		this.cost = cost;
		this.cameFrom = cameFrom;
	}

	public T getState() {
		return state;
	}

	public void setState(T state) {
		this.state = state;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public State<T> getCameFrom() {
		return cameFrom;
	}

	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		return other.getClass().equals(getClass()) && state.equals(((State<T>) other).getState());
	}
	@Override
	public int hashCode() {
		return state.hashCode();
	}
}
