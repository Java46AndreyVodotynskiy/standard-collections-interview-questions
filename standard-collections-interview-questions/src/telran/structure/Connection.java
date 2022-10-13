package telran.structure;

public class Connection {
	int id;
	String ipAdress;
	int port;
	public Connection(int id, String ipAdress, int port) {
	
		this.id = id;
		this.ipAdress = ipAdress;
		this.port = port;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIpAdress() {
		return ipAdress;
	}
	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

}
