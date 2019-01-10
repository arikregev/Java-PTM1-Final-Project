package test;

import server_side.BestFS;
import server_side.FileCacheManager;
import server_side.GraphSolver;
import server_side.MyClientHandler;
import server_side.MySerialServer;
import server_side.Server;
import server_side.Vertix;

public class TestSetter {
	

	static Server s; 
	
	public static void runServer(int port) {
		// put the code here that runs your server
		s=new MySerialServer(port, new MyClientHandler(new GraphSolver(new BestFS<Vertix>()),new FileCacheManager<String,String>())); // initialize
		s.start();
	}

	public static void stopServer() {
		s.stop();
	}
	

}
