
public class Utente extends Thread{
	
	CokeMachineIf c;
	
	public Utente(CokeMachineIf c,int id) {
		this.c=c;
		this.setName("Utente "+id);
	}
	
	public void run() {
		while(true) {
			c.preleva();
			try {
				sleep((int) Math.random()*5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
