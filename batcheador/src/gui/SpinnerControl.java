package gui;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import core.Ibatcheable;

public class SpinnerControl extends BatchControl{
	JSpinner input;
	List<String> options = new ArrayList<String>();
	SpinnerListModel optionsModel;
	public SpinnerControl(Field f, Ibatcheable b) {
		super(f,b);
		options.add("a");
		options.add("b"); // TODO add real options
		optionsModel = new SpinnerListModel(options);
		this.input = new JSpinner(optionsModel);
		input.setMinimumSize(input.getPreferredSize());
		input.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					field.set(b, input.getValue());
				} catch (IllegalArgumentException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(input);
	}

	public JSpinner getInput() {
		return input;
	}

	public void setInput(JSpinner input) {
		this.input = input;
	}
	
	public List<String> getOptions(){
		return options;
	}
	
	public void setOptions(List<String> options){
		this.options = options;
	}

}