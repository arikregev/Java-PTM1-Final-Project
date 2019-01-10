//Arik Regev

package server_side;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Graph implements Searchable<Vertix> {
	private HashMap<Vertix,HashMap<Vertix,Integer>> graphArr;
	private Vertix start;
	private Vertix end;
	
	public Graph(Collection<Vertix> vertices, Collection<Edge> edges, Vertix start, Vertix end) {
		this.start = start;
		this.end = end;
		graphArr = new HashMap<Vertix,HashMap<Vertix,Integer>>();
		for(Vertix v : vertices) {
			graphArr.put(v, new HashMap<Vertix,Integer>());
		}
		for(Edge e : edges) {
			graphArr.get(e.getSource()).put(e.getDest(), e.getWeight());
		}
	}
	@Override
	public State<Vertix> getInitialState() {
		return new State<Vertix>(start);
	}

	@Override
	public State<Vertix> getGoalState() {
		return new State<Vertix>(end);
	}

	@Override
	public ArrayList<State<Vertix>> getAllPossibleStates(State<Vertix> s) {
		ArrayList<State<Vertix>> states = new ArrayList<State<Vertix>>();
		HashMap<Vertix, Integer> neighbors = graphArr.get(s.getState());
		for(Vertix neighbor : neighbors.keySet()) {
			states.add(new State<Vertix>(neighbor,s.getCost()+neighbors.get(neighbor),s));
		}
		return states;
	}
	
	@Override
	public String toString() {// For Debug Purposes
		StringBuilder retval=new StringBuilder();
		retval.append("Graph:\n");
		retval.append("\tStart: ").append(start.getId()).append("\n");
		retval.append("\tEnd: ").append(end.getId()).append("\n");
		retval.append("\tVertix List:\n");
		for (Vertix v: graphArr.keySet()) {
			retval.append("\t\t").append(v.getId()).append(": ");
			for (Vertix vdest: graphArr.get(v).keySet()) {
				retval.append("(").append(vdest.getId()).append(", w=").append(graphArr.get(v).get(vdest)).append(")");
			}
			retval.append("\n");
		}
		
		
		return retval.toString();
		
	}

}
