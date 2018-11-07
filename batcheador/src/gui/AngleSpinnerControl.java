package gui;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import core.Ibatcheable;

public class AngleSpinnerControl extends BatchControl{
	JSpinner inputAngle;
	List<String> options = new ArrayList<String>();
	SpinnerNumberModel modelAngle;
	JLabel textAngle;
	
	public AngleSpinnerControl(Field f, Ibatcheable b) {
		super(f,b);
		
		modelAngle = new SpinnerNumberModel(0,0,360,1); 
		this.inputAngle = new JSpinner(modelAngle);

		inputAngle.setMinimumSize(inputAngle.getPreferredSize());
		
		textAngle = new JLabel("°");
		
		inputAngle.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					field.set(b, getValueInputs());
				} catch (IllegalArgumentException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		panel.add(inputAngle);
		panel.add(textAngle);

	}

	public String getValueInputs() {
		String output = String.format("\"rotate=%s*PI/180",inputAngle.getValue().toString());
		if (((int) inputAngle.getValue())%90==0) output +=  ":bilinear=0";
		output+=", format = yuv420p\"";
		return output;
	}

	public void setHoursInput(JSpinner input) {
		this.inputAngle = input;
	}
	
}