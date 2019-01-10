//Arik Regev
package server_side;

//import java.util.ArrayList;

public interface Solver<Problem, Solution> {
	//public ArrayList<String> solve(ArrayList<int[]> matrix, int[] sPoint, int[] ePoint /*,int lineLen*/);//Add by Arik
	public Solution solve(Problem p);
	
}