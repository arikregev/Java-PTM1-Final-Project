//Arik Regev

package server_side;

import java.util.PriorityQueue;


public abstract class CommonSearcher<T> implements Searcher<T> {
	protected PriorityQueue<State<T>> openList;
	private int evaluatedNodes;
	
	public CommonSearcher() {
		this.openList = new PriorityQueue<State<T>>(11,new StateComperator<T>());
		this.evaluatedNodes = 0;
	}
	
	protected State<T> popOpenList() {
		this.evaluatedNodes++;
		return this.openList.poll();
	}
	
	protected void addToOpenList(State<T> s) {
		this.openList.add(s);
	}
	
	protected boolean openListContains(State<T> s) {
		return openList.contains(s);
	}
	@Override
	public int getNumberOfNodesEvaluated() {
		return this.evaluatedNodes;
	}
	protected SearchSolution<T> backTrace(State<T> goalState, State<T> initialState) {
		SearchSolution<T> sol = new SearchSolution<T>();
		for(State<T> s = goalState; !s.equals(initialState); s = s.getCameFrom()) {
			sol.pushToFront(s.getState());
		}
		sol.pushToFront(initialState.getState());
		return sol;
	}
}
 