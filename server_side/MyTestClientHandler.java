//Arik Regev

package server_side;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MyTestClientHandler implements ClientHandler {
	private CacheManager<String, String> c;
	private Solver<String, String> solver;

	public MyTestClientHandler(Solver<String, String> nsolve, CacheManager<String, String> nCm) {
		this.c = nCm;
		this.solver = nsolve;
		}
	public void handleClient(InputStream I, OutputStream O) {
		BufferedReader userInput= new BufferedReader(new InputStreamReader(I));
		PrintWriter output = new PrintWriter(new OutputStreamWriter(O));
		readInputsAndSend(userInput, output, "end");
		
	}
	private void readInputsAndSend(BufferedReader userInput, PrintWriter output, String quitStr) {
		try {
		String line;
		while(!(line = userInput.readLine()).equals(quitStr)) {
			String returnString;
			if(this.c.isSolutionCached(line) == true)
				output.println(c.getSolution(line));
			else {
				returnString = solver.solve(line);
				this.c.saveSolution(line, returnString);
				output.println(returnString);
			}
			output.flush();
		}
		}catch (IOException e) {e.printStackTrace(); }
	}
}     
  