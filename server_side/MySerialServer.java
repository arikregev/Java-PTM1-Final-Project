//Arik Regev

package server_side;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MySerialServer implements Server {
	
	private int port;
	private ClientHandler c;
	private volatile boolean stopSrv;

	public MySerialServer(int nPort, ClientHandler nCH) {
		this.port = nPort;
		this.c = nCH;
		this.stopSrv = false;
	}
	
	@Override
	public void open(int port, ClientHandler c) {
		this.port = port;
		this.c = c;
		this.stopSrv = false;
	}
	public void start(){
		new Thread(()->{
			try {
				runServer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
	
	private void runServer() throws Exception {
		ServerSocket Server = new ServerSocket(port);
		Server.setSoTimeout(1000);
		while(!stopSrv) {
			try {
				Socket aClient = Server.accept(); //Waiting for connection from Client, Blocking Call
				try {
				c.handleClient(aClient.getInputStream(), aClient.getOutputStream());
				aClient.getInputStream().close();
				aClient.getOutputStream().close();
				aClient.close();
				}catch(IOException e) {/*...*/}
				}catch(SocketTimeoutException e) {}
			}
		Server.close();
	}

	@Override
	public void stop() {
		stopSrv = true;
	}
	
	//*******************EvenD3**************************
	public MySerialServer(int nPort) {//Even D3
		this.port = nPort;
		this.stopSrv = false;
	}
	public void start(MyClientHandler m) {
		this.c = m;
	}
}
