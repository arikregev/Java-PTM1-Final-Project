//Arik Regev

package server_side;

import java.util.ArrayList;

public interface Searchable<T> {

	State<T> getInitialState();
	State<T> getGoalState();
	ArrayList<State<T>> getAllPossibleStates(State<T> s);
}
