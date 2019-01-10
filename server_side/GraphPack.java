//Arik Regev

package server_side;

import java.util.ArrayList;

public class GraphPack {
	private ArrayList<int[]> mat;
	private int[] sPoint;
	private int[] ePoint;
	public GraphPack(ArrayList<int[]> mat, int[] sPoint, int[] ePoint) {
		
		this.mat = mat;
		this.sPoint = sPoint;
		this.ePoint = ePoint;
	}
	public ArrayList<int[]> getMat() {
		return mat;
	}
	public int[] getsPoint() {
		return sPoint;
	}
	public int[] getePoint() {
		return ePoint;
	}
	
}
