package example;


import java.util.Observable;

public class Model extends Observable {

	public void calculate() throws InterruptedException {
		for (int i = 0; i < 100; ++i) {
			Thread.sleep(100);
			setChanged();
			notifyObservers(new Integer(i).toString());
		}
	}
}
