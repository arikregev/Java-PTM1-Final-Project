//Arik Regev

package server_side;

public class Edge {
	private Vertix source;
	private Vertix dest;
	private int weight;
	
	public Edge(Vertix src, Vertix dest, int weight) {
		this.source = src;
		this.dest = dest;
		this.weight = weight;
	}

	public Vertix getSource() {
		return source;
	}

	public Vertix getDest() {
		return dest;
	}

	public int getWeight() {
		return weight;
	}
	
	
}
