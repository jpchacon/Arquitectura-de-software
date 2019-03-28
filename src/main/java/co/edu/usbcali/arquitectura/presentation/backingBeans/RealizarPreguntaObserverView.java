package co.edu.usbcali.arquitectura.presentation.backingBeans;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import co.edu.usbcali.arquitectura.MVCObserver.Observer;
import co.edu.usbcali.arquitectura.MVCObserver.Order;
import co.edu.usbcali.arquitectura.MVCObserver.RespuestaObserver;
import co.edu.usbcali.arquitectura.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.arquitectura.utilities.FacesUtils;


@ManagedBean
@ViewScoped
public class RealizarPreguntaObserverView {
	
	
	RespuestaObserver respuestaObserver = new RespuestaObserver();
	Observer order = new Order(respuestaObserver);
	int notificacionId = 1;
	
	private InputText txtPregunta;
	private String txtRespuesta;
	private String state = "";
	
	private CommandButton btnExecuteAction;
	private CommandButton btnFindAction;
	private CommandButton btnClearAction;
	
	
	@ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;
    
	
	
	public RealizarPreguntaObserverView() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public InputText getTxtPregunta() {
		return txtPregunta;
	}
	public void setTxtPregunta(InputText txtPregunta) {
		this.txtPregunta = txtPregunta;
	}
	public String getTxtRespuesta() throws Exception{
		
		//txtRespuesta = businessDelegatorView.preguntaResponde((txtPregunta.toString()));
		
		return txtRespuesta;
	}
	public void setTxtRespuesta(String txtRespuesta) {
		this.txtRespuesta = txtRespuesta;
	}
	
	public CommandButton getBtnExecuteAction() {
		return btnExecuteAction;
	}


	public void setBtnExecuteAction(CommandButton btnExecuteAction) {
		this.btnExecuteAction = btnExecuteAction;
	}


	public CommandButton getBtnFindAction() {
		return btnFindAction;
	}


	public void setBtnFindAction(CommandButton btnFindAction) {
		this.btnFindAction = btnFindAction;
	}


	public CommandButton getBtnClearAction() {
		return btnClearAction;
	}


	public void setBtnClearAction(CommandButton btnClearAction) {
		this.btnClearAction = btnClearAction;
	}


	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}
	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}


	public String ClearAction() {
		txtPregunta.resetValue();
		txtRespuesta = "";
		state = "";

		return "";
	}
	
	public String ExecuteAction() throws Exception {
		respuestaObserver.register(order);
		FacesUtils.addInfoMessage(order.update());
		state = businessDelegatorView.preguntaResponde(txtPregunta.getValue().toString());
		
		return ""; 
	}
	
	public String FindAction() throws Exception {
		if(state != null) {
			respuestaObserver.setReady(true);
		}else {
			respuestaObserver.setReady(false);
		}
		
		txtRespuesta = state;
		FacesUtils.addInfoMessage(order.update());
		
	
	
	
		return "";
	}
}
