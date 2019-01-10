//Arik Regev

package server_side;

public interface Server {

	public void open(int port, ClientHandler c);
	public void stop();
	public void start();
	public void start(MyClientHandler myCH);//
}
