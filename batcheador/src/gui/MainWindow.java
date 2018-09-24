package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;

import batcheador.Batcheable;
import core.Ibatcheable;

public class MainWindow {
	List<Ibatcheable> batcheables = new ArrayList<Ibatcheable>();
	JFrame frame;
	JPanel panel;
	JLabel textLabel;
	JSpinner spinner;
	JButton button;
	SpinnerListModel spinnerModel;
	String[] options;

	public MainWindow(List<Ibatcheable> batcheables) {
		this.batcheables = batcheables;

		frame = new JFrame("Batcheador");
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
		
		options = obtenerNombresBatcheables(batcheables);
		textLabel = new JLabel("Seleccione una aplicación", SwingConstants.CENTER);
		spinnerModel = new SpinnerListModel(options);
		spinner = new JSpinner(spinnerModel);
		button = new JButton("Aceptar");
		
		button.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	            new BatcheableWindow(batcheables.stream().filter(app -> app.getClass().getAnnotation(Batcheable.class).name().equals(spinner.getValue())).findFirst().get());
	          }
	    }); 
		
		frame.add(textLabel);
		frame.add(spinner);
		frame.add(button);
		frame.pack();
		frame.setVisible(true);

	}
	
	public String[] obtenerNombresBatcheables(List<Ibatcheable> batcheables){
		return batcheables.stream().map(app -> app.getClass().getAnnotation(Batcheable.class).name()).toArray(String[]::new);
	}

}
