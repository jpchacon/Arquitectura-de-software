package co.edu.usbcali.arquitectura.MVCObserver;

public interface Subject {
	
	void register(Observer o);
	void unRegister(Observer o);
	void notifyObservers();
	
	boolean getReady();
	void setReady(boolean b);
}
