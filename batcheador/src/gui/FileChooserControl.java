package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import core.Ibatcheable;

public class FileChooserControl extends BatchControl{
	JFileChooser input;
	JButton button;
	public FileChooserControl(Field f, Ibatcheable b) {
		super(f,b);
		
		button = new JButton("Open");
		button.addActionListener(new ActionListener() {
			JFileChooser input;
		    public void actionPerformed(ActionEvent e) {
				this.input = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());		
				
				int returnValue = input.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					if (input.getSelectedFile().isFile()) {
						try {
							field.set(b, input.getSelectedFile());
						} catch (IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
		    }
		});
		
		panel.add(button);
		
	}

	public JFileChooser getInput() {
		return input;
	}

	public void setInput(JFileChooser input) {
		this.input = input;
	}

}