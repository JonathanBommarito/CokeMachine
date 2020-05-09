import java.util.concurrent.Semaphore;

public class CokeMachine implements CokeMachineIf {

	static final int N = 50;
	int count;
	public Semaphore mutex;
	public Semaphore empty;

	public CokeMachine() {
		mutex = new Semaphore(1);
		empty = new Semaphore(0);
		count = N;
	}

	public void preleva() {
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count > 0) {
			count--;
			System.out.println(Thread.currentThread().getName() + " preleva una lattina");
		}
		System.out.println("Lattine rimanenti: " + count);
		if (count == 0) {
			System.out.println("La macchinetta è vuota, sto chiamando il rifornitore");
			empty.release();

		}
		mutex.release();

	}

	public void rifornisci() {
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			empty.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count = N;
		System.out.print("Macchinetta rifornita, n lattine:  " + count);
		mutex.release();

	}

}
