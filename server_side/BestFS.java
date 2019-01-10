//Arik Regev

package server_side;

import java.util.ArrayList;
import java.util.HashSet;

public class BestFS<T> extends CommonSearcher<T> {

	@Override
	public SearchSolution<T> search(Searchable<T> s) {
		addToOpenList(s.getInitialState());
		HashSet<State<T>> closedSet = new HashSet<State<T>>();
		
		while(openList.size()>0) {
			State<T> n = popOpenList();
			closedSet.add(n);
			
			if(n.equals(s.getGoalState())) {
				return backTrace(n, s.getInitialState());
			}
			ArrayList<State<T>> successors = s.getAllPossibleStates(n);
			for(State<T> state : successors) {
				if(closedSet.contains(state))
					continue;
				//state.setCameFrom(n);
				if(!openListContains(state)) {
					addToOpenList(state);
				}else {
					for(State<T> currentState : openList) {
						if(!currentState.equals(state))
							continue;
						if(state.getCost() < currentState.getCost()) {
							openList.remove(currentState);
							addToOpenList(state);
						}
						break;
					}
				}
			}
		}
		return null;
	}
}
