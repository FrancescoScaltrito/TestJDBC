
public class Macchina {
	String targa;
	String modello;
	int cc;
	public Macchina(String targa, String modello, int cc) {
		super();
		this.targa = targa;
		this.modello = modello;
		this.cc = cc;
	}
	public Macchina() {
		super();
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	
	
}
