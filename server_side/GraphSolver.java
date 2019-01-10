//Arik Regev

package server_side;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GraphSolver implements Solver<GraphPack, ArrayList<Direction>> {
	private Searcher<Vertix> searcher;
	
	public GraphSolver(Searcher<Vertix> searcher) {
		this.searcher = searcher;
	}

	@Override
	public ArrayList<Direction> solve(GraphPack p) {
		int numRows = p.getMat().size();
		int numCols = p.getMat().get(0).length;
		ArrayList<Vertix> vertices = new ArrayList<Vertix>();
		for(int i = 0; i<numRows*numCols; i++) {
			vertices.add(new Vertix(i));
		}
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int row = 0; row < numRows; row++) {
			for(int col = 0 ; col < numCols; col++) {
				if(col > 0)
					edges.add(new Edge(vertices.get(row*numCols+col),
							vertices.get(row*numCols+col-1),p.getMat().get(row)[col-1]));
				if(col < numCols - 1)
					edges.add(new Edge(vertices.get(row*numCols+col),
							vertices.get(row*numCols+col+1),p.getMat().get(row)[col+1]));
				if(row > 0)
					edges.add(new Edge(vertices.get(row*numCols+col),
							vertices.get((row-1)*numCols+col),p.getMat().get(row-1)[col]));
				if(row < numRows-1)
					edges.add(new Edge(vertices.get(row*numCols+col),
							vertices.get((row+1)*numCols+col),p.getMat().get(row+1)[col]));	
			}
		}
		Vertix st = vertices.get(p.getsPoint()[0]*numCols+p.getsPoint()[1]);
		Vertix end = vertices.get(p.getePoint()[0]*numCols+p.getePoint()[1]);
		Graph g = new Graph(vertices, edges, st, end);
		//System.out.println(g.toString());
		
		SearchSolution<Vertix> solution = this.searcher.search(g);
		//System.out.println("SearchSolution: " + solution.toString());
		
		ArrayList<Direction> directions = new ArrayList<Direction>();
		
		int solutionSize = solution.getSolution().size();
		List<Vertix> froms = solution.getSolution().subList(0, solutionSize-1);
		List<Vertix> tos = solution.getSolution().subList(1, solutionSize);
		ListIterator<Vertix> fromsIter = froms.listIterator();
		ListIterator<Vertix> tosIter = tos.listIterator();
		for(;fromsIter.hasNext();) {
			Vertix from = fromsIter.next();
			Vertix to = tosIter.next();
			
			if(from.getId()-1 == to.getId())
				directions.add(Direction.Left);
			if(from.getId()+1 == to.getId())
				directions.add(Direction.Right);
			if(from.getId()-numCols == to.getId())
				directions.add(Direction.Up);
			if(from.getId()+numCols == to.getId())
				directions.add(Direction.Down);
		}
		return directions;
	}
}
