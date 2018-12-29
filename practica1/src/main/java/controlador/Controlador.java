package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.swing.JPanel;

import interceptor.PanelButones;

@ManagedBean(name = "controlador", eager = true) //Tiene que ser un Managed Bean para ser llamado por el .xhtml
@SessionScoped
public class Controlador {
	
	private String headerLabel1 = "APAGADO";
	private String headerLabel2 = "ACELERANDO";
	
	private String encenderLabel1 = "Encender";
	private String encenderLabel2 = "Apagar";
	
	private String acelerarLabel = "Acelerar";
	
	private boolean butonEncenderOn = false;
	private boolean butonAcelerarOn = false;
	
	private PanelButones panel = null;
	
	public Controlador() {
		
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void setPanel(PanelButones panel) {
		this.panel = panel;
	}
	
	public String getHeaderLabel() {
		if(butonEncenderOn==true && butonAcelerarOn==true)
			return headerLabel2;
		else
			return headerLabel1;
	}
	
	public String getEncenderLabel() {
		if(butonEncenderOn==true)
			return encenderLabel2;
		else
			return encenderLabel1;
	}
	
	public String getAcelerarLabel() {
		return acelerarLabel;
	}
	
	public void cambiarEncenderButon() { //Tiene que recibir un ActionEvent
		if(butonEncenderOn==false)
			butonEncenderOn = true;
		else {
			butonEncenderOn = false;
			butonAcelerarOn = false;
		}
	}
	
	public void cambiarAcelerarButon() { //Tiene que recibir un ActionEvent
		if(butonEncenderOn==true) {
			butonAcelerarOn = true;
		}	
		else
			butonEncenderOn = false;
	}
	
}