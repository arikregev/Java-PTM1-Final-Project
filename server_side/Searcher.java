//Arik Regev

package server_side;

public interface Searcher<T> {

		public SearchSolution<T> search(Searchable<T> s);//Return Solution using search Method
		public int getNumberOfNodesEvaluated(); 
}
