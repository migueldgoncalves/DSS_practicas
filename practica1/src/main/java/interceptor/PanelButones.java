package interceptor;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.faces.bean.ManagedBean;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

@ManagedBean(name = "panelButones", eager = true)
public class PanelButones extends JPanel {
	private javax.swing.JButton BotonAcelerar;
	private javax.swing.JToggleButton BotonEncender;
	private javax.swing.JLabel EtiqMostrarEstado;
	
	private String label = "APAGADO";
	
	public PanelButones() {
		//Crear objetos-botones, etiquetas
		//Fijar el aspecto de los paneles con setLayout() y setBorder()
		//crear subpaneles: ... new JPanel()
		//Adaptar las etiquetas e incluirlas en los subpaneles
		//subpanel.add(EtiqMostrarEstado); this.add(subpanel2);
		//...
		//...lo mismo con los 2 botones
		BotonAcelerar = new javax.swing.JButton("Acelerar");
		BotonEncender = new javax.swing.JToggleButton("Encender", false);
		EtiqMostrarEstado = new javax.swing.JLabel("APAGADO");
		
		JPanel p = new JPanel(new BorderLayout());
		JPanel subPanel1 = new JPanel(new BorderLayout());
		JPanel subPanel2 = new JPanel(new BorderLayout());
		p.add(subPanel1);
		p.add(subPanel2);
		subPanel1.add(EtiqMostrarEstado);
		subPanel2.add(BotonEncender);
		subPanel2.add(BotonAcelerar);
		p.setBorder(BorderFactory.createLineBorder(Color.blue));
		//p.setLayout(new FlowLayout());
		JFrame jframe = new JFrame();
		jframe.add(p);
		jframe.setVisible(true);
	}
	
	//recogedor de eventos del boton Encender
	synchronized private void ButonEncenderActionPerformed(java.awt.event.ActionEvent evt) {
		if(BotonEncender.isSelected()) {
			BotonEncender.setText("Apagar");
		}
		else {
			BotonEncender.setText("Encender");
		}
	}
	
	//recogedor de eventos del boton Acelerar
	synchronized private void ButonAcelerarActionPerformed(java.awt.event.ActionEvent evt) {
		if(BotonAcelerar.isSelected()) {
			//Programar el cambio del aspecto del boton
		}
		else {
			//Programar el cambio del aspecto del boton
		}
	}
	
	public String getLabel() {
		return label;
	}
}
