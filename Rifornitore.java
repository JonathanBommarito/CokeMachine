
public class Rifornitore extends Thread {
	
	CokeMachineIf c;
	
	public Rifornitore(CokeMachineIf c) {
		this.c=c;		
	}
	
	public void run() {
		while(true) {
		c.rifornisci();	
		}
	}
}
