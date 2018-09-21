package gui;

import java.awt.GridLayout;
import java.lang.reflect.Field;

import javax.swing.JLabel;
import javax.swing.JPanel;

import batcheador.Parameter;
import core.Ibatcheable;

public abstract class BatchControl {

	protected JLabel label;
	protected Field field;
	protected JPanel panel;

	public BatchControl(Field f, Ibatcheable b) {
		super();
		this.field = f;
		this.label = new JLabel(field.getAnnotation(Parameter.class).label());
		panel = new JPanel();
		panel.add(label);
		panel.setLayout(new GridLayout());
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	public JPanel getPanel() {return panel;}
	

}