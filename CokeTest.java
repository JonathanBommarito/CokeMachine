
public class CokeTest {

	public static void main(String[] args) {
		
		CokeMachineIf c = new CokeMachine();
		Thread rif = new Rifornitore(c);
		rif.start();
		for ( int i=0;i<5;i++) {
			Thread u = new Utente(c, i);
			u.start();
		}
		
	}

}
