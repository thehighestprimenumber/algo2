package gui;

import java.lang.reflect.Field;

import javax.swing.JTextField;

import core.Ibatcheable;

public class TextControl extends BatchControl{
	JTextField input;
	public TextControl(Field f, Ibatcheable b) {
		super(f,b);
		this.input = new MyTextField(f, b);
		panel.add(input);
	}

	public String getInput() {
		return input.getText();
	}

	public void setInput(String input) {
		this.input.setText(input);
	}
}

