//Arik Regev

package server_side;

import java.util.LinkedList;

public class SearchSolution<T> {
	private LinkedList<T> solution;

	public SearchSolution() {
		this.solution = new LinkedList<T>();
	}
	public void pushToFront(T t) {
		this.solution.push(t);
	}
	public LinkedList<T> getSolution() {
		return this.solution;
	}
		
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Solution: [");
		for (T t: solution.subList(0, solution.size()-1)) {
			s.append(t.toString()).append(",");
		}
		s.append(solution.getLast().toString()).append("]");
		return s.toString();
	}
}
