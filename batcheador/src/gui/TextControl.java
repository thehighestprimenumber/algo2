package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JTextField;

import core.Ibatcheable;

public class TextControl extends BatchControl{
	JTextField input;
	public TextControl(Field f, Ibatcheable b) {
		super(f,b);
		this.input = new JTextField();
		input.setMinimumSize(input.getPreferredSize());
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					field.set(b, input.getText());
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
