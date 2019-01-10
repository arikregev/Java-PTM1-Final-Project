//Arik Regev
package server_side;

public interface CacheManager<Problem, Solution> {

	boolean isSolutionCached(Problem p);
	Solution getSolution(Problem p);
	void saveSolution(Problem p, Solution s);
}
