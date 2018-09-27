package gui;

import java.awt.Font;
import java.lang.reflect.Field;

import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import core.Ibatcheable;

@SuppressWarnings("serial")
class MyTextField extends JTextField{
		MyTextField (Field f, Ibatcheable b){
			try {
				setText((String) f.get(b));
				setFont(getFont().deriveFont(Font.ITALIC));
			} catch (IllegalArgumentException | IllegalAccessException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} 
			setMinimumSize(getPreferredSize());
			addCaretListener(new CaretListener() {
				@Override
				public void caretUpdate(CaretEvent e) {
					try {
						f.set(b, getText());
						setFont(getFont().deriveFont(Font.PLAIN));
					} catch (IllegalArgumentException | IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});	
		}
		
}