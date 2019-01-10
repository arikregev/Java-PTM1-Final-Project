//Arik Regev

package server_side;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Consumer;


public class MyClientHandler implements ClientHandler {
	
	private CacheManager<String,String> c;
	private Solver<GraphPack,ArrayList<Direction>> solver;
	
	public MyClientHandler(Solver<GraphPack,ArrayList<Direction>> nsolve, CacheManager<String,String> nCm) {
		this.c = nCm;
		this.solver = nsolve;
		}

	@Override
	public void handleClient(InputStream I, OutputStream O) {
		BufferedReader userInput= new BufferedReader(new InputStreamReader(I));
		PrintWriter output = new PrintWriter(new OutputStreamWriter(O));
		readInputsAndSend(userInput, output, "end");

	}
	private int[] parseLine(String lineIn) {
		String[] arr = lineIn.split(",");
		int[] row = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
			row[i] = Integer.parseInt(arr[i]);
		return row;
	}
	private void readInputsAndSend(BufferedReader userInput, PrintWriter output, String quitStr) {
		try {
			ArrayList<int[]> matrix = new ArrayList<int[]>();
			String line = userInput.readLine();
			while(!line.equals(quitStr)) {
				matrix.add(parseLine(line));
				line = userInput.readLine();
			}
			//int lineLen = matrix.get(0).length; //For Debug Peruses
			int[] sPoint = parseLine(userInput.readLine());
			int[] ePoint = parseLine(userInput.readLine());
			
			ArrayList<Direction> solution = solver.solve(new GraphPack(matrix,sPoint,ePoint));
			ArrayList<String> solutionStrings = new ArrayList<String>();
			for (Direction d: solution)
				solutionStrings.add(d.toString());
			//System.out.println(String.join(",", solutionStrings)); //For Debug Peruses
			output.print(String.join(",", solutionStrings));
			output.flush();
		
		}catch (IOException e) {e.printStackTrace(); }
	}
	
	
}     
  
