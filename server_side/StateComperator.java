//Arik Regev

package server_side;

import java.util.Comparator;

public class StateComperator<T> implements Comparator<State<T>> {

	@Override
	public int compare(State<T> o1, State<T> o2) {
		if (o1.equals(o2) && o1.getCost() != o2.getCost())
			throw new RuntimeException("pushed to equal states to priority queue! v" + o1.getState().toString());
		if(o1.equals(o2))
			//
			return 0;
		return o1.getCost()-o2.getCost();
	}

}
