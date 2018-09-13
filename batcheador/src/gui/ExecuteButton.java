package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ExecuteButton extends JButton {
	ExecuteButton(){
		super("Ejecutar");
		addActionListener(new ExecuteButtonListener());
	}
}
	
	class ExecuteButtonListener implements ActionListener {
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO validar y ejecutar comando
		
	}
}
