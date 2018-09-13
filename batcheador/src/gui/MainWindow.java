package gui;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;

public class MainWindow {

	List<Field> fields = new ArrayList<Field>();
	Ibatcheable batcheable;
	JFrame frame;
	JPanel panel;

	public MainWindow(Ibatcheable batcheable) {
		this.batcheable = batcheable;

		frame = new JFrame(batcheable.getClass().getAnnotation(Batcheable.class).name());
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

		for (Field field : batcheable.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(Parameter.class))
				fields.add(field);
			BatchControl component;
			try {
				Class<?> clazz = Class.forName(field.getAnnotation(Parameter.class).control());
				component = (BatchControl) clazz.getConstructor(Field.class, Ibatcheable.class).newInstance(field,
						batcheable);
				frame.add(component.getPanel());
			} catch (Exception ex) {
				ex.printStackTrace(); // TODO
			}

		}
		frame.add(new ExecuteButton());
		frame.pack();
		frame.setVisible(true);

	}

}
