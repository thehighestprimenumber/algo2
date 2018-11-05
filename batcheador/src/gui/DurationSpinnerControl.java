package gui;

import java.awt.Dimension;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import core.Ibatcheable;

public class DurationSpinnerControl extends BatchControl{
	JSpinner inputHours;
	JSpinner inputMinutes;
	JSpinner inputSeconds;
	List<String> options = new ArrayList<String>();
	SpinnerNumberModel modelHours;
	SpinnerNumberModel modelMinutes;
	SpinnerNumberModel modelSeconds;
	JLabel textHs;
	JLabel textMin;
	JLabel textSec;
	
	public DurationSpinnerControl(Field f, Ibatcheable b) {
		super(f,b);
		
		modelHours = new SpinnerNumberModel(); 
		modelMinutes = new SpinnerNumberModel(0,0,59,1);
		modelSeconds = new SpinnerNumberModel(0,0,59,1);

		this.inputHours = new JSpinner(modelHours);
		this.inputMinutes = new JSpinner(modelMinutes);
		this.inputSeconds = new JSpinner(modelSeconds);

		inputHours.setMinimumSize(inputHours.getPreferredSize());
		inputMinutes.setMinimumSize(inputMinutes.getPreferredSize());
		inputSeconds.setMinimumSize(inputSeconds.getPreferredSize());
		
		textHs = new JLabel("hs");
		textMin = new JLabel("min");
		textSec = new JLabel("sec");
		
		inputHours.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					field.set(b, getValueInputs());
				} catch (IllegalArgumentException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		inputMinutes.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					field.set(b, getValueInputs());
				} catch (IllegalArgumentException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		inputSeconds.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					field.set(b, getValueInputs());
				} catch (IllegalArgumentException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(inputHours);
		panel.add(textHs);
		panel.add(inputMinutes);
		panel.add(textMin);
		panel.add(inputSeconds);
		panel.add(textSec);

	}

	public String getValueInputs() {
		return inputHours.getValue().toString() + ":" + inputMinutes.getValue().toString() + ":" + inputSeconds.getValue().toString();
	}

	public void setHoursInput(JSpinner input) {
		this.inputHours = input;
	}
	
	public void setMinutesInput(JSpinner input) {
		this.inputHours = input;
	}
	
	public void setSecondsInput(JSpinner input) {
		this.inputHours = input;
	}
}