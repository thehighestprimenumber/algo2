package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import core.Ibatcheable;

public class TextControl extends BatchControl{
	JTextField input;
	public TextControl(Field f, Ibatcheable b) {
		super(f,b);
		this.input = new JTextField();
		try {
			input.setText((String) f.get(b));
			input.setFont(input.getFont().deriveFont(Font.ITALIC));
			
		} catch (IllegalArgumentException | IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		input.setMinimumSize(input.getPreferredSize());
		input.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				try {
					field.set(b, input.getText());
					input.setFont(input.getFont().deriveFont(Font.PLAIN));
				} catch (IllegalArgumentException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		panel.add(input);
	}

	public JTextField getInput() {
		return input;
	}

	public void setInput(JTextField input) {
		this.input = input;
	}

}
