//Arik Regev

package server_side;

import java.util.HashMap;

public class FileCacheManager<Problem, Solution> implements CacheManager<Problem, Solution> {

	HashMap<Problem, Solution> MyHashMap= new HashMap<>(); 
	
	@Override
	public boolean isSolutionCached(Problem p) {
		return MyHashMap.containsKey(p);
	}

	@Override
	public Solution getSolution(Problem p) {
		return MyHashMap.get(p);
	}

	@Override
	public void saveSolution(Problem p, Solution s) {
		MyHashMap.put(p, s);
		
	}

	
}
