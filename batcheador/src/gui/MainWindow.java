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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.ListModel;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import batcheador.Batcheable;
import core.Ibatcheable;

public class MainWindow {
	List<Ibatcheable> batcheables = new ArrayList<Ibatcheable>();
	JFrame frame;
	JPanel panel;
	JLabel textLabel;
	JList<String> list;
	JButton button;
	String[] options;

	public MainWindow(List<Ibatcheable> batcheables) {
		this.batcheables = batcheables;

		frame = new JFrame("Batcheador");
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		button = new JButton("Aceptar");
		button.setEnabled(false);
	    button.setAlignmentX(JButton.CENTER_ALIGNMENT);

		
		options = obtenerNombresBatcheables(batcheables);
		textLabel = new JLabel("Seleccione una aplicación", SwingConstants.CENTER );
	    textLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	    
		list = new JList<String>(options);
	    list.setAlignmentX(JList.CENTER_ALIGNMENT);

		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				button.setEnabled(true);
				
			}
		});
		
		button.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent e) {
	            new BatcheableWindow(batcheables.stream().filter(app -> app.getClass().getAnnotation(Batcheable.class).name().equals(list.getSelectedValue())).findFirst().get());
	           
	          }
	    }); 
		
		frame.add(textLabel);
		frame.add(list);
		frame.add(button);
		//frame.pack();
		frame.setSize(250, 150);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public String[] obtenerNombresBatcheables(List<Ibatcheable> batcheables){
		return batcheables.stream().map(app -> app.getClass().getAnnotation(Batcheable.class).name()).toArray(String[]::new);
	}

}
