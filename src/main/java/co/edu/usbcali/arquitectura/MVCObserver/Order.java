package co.edu.usbcali.arquitectura.MVCObserver;

public class Order implements Observer {
	
	
	
	private Subject subject = null;
	
	public Order(Subject s) {
		this.subject = s;
	}
	
	@Override
	public String update() {
		
		if(subject.getReady()) {
			subject.unRegister(this);
			return "Se muestra la respuesta!";
		}else {
			return "La respuesta esta lista!";
		}
		
	}

}
