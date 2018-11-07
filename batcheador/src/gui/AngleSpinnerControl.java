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

/*-vf "transpose = 0" = 90CounterCLockwise and Vertical Flip (default)
-vf "transpose = 1" = 90Clockwise
-vf "transpose = 2" = 90CounterClockwise
-vf "transpose = 3" = 90Clockwise and Vertical Flip
-vf "transpose = 2, transpose = 2, " = 180Flip*/

public class AngleSpinnerControl extends BatchControl{
	JSpinner inputAngle;
	List<String> options = new ArrayList<String>();
	SpinnerNumberModel modelAngle;
	JLabel textAngle;
	
	public AngleSpinnerControl(Field f, Ibatcheable b) {
		super(f,b);
		
		modelAngle = new SpinnerNumberModel(0,0,360,90); 
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
//		switch (inputAngle.getValue()) {
//				rem 0 = 90CounterCLockwise and Vertical Flip (default)
//				rem 1 = 90Clockwise
//				rem 2 = 90CounterClockwise
//				rem 3 = 90Clockwise and Vertical Flip
//		}
		
		
		return inputAngle.getValue().toString();
	}

	public void setHoursInput(JSpinner input) {
		this.inputAngle = input;
	}
	
}