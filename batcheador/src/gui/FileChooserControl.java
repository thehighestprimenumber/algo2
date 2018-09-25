package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileSystemView;

import core.Ibatcheable;

public class FileChooserControl extends BatchControl{
	private JFileChooser input;
	private JButton button;
	private JLabel fileLabel;
	public FileChooserControl(Field f, Ibatcheable b) {
		super(f,b);
		
		button = new JButton("Select file");
		fileLabel = new JLabel("Select file");
		
		JFileChooser input = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		button.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {
				int returnValue = input.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					if (input.getSelectedFile().isFile()) {
						try {
							field.set(b, input.getSelectedFile().getAbsolutePath());
							fileLabel.setText(input.getSelectedFile().getAbsolutePath());
						} catch (IllegalArgumentException | IllegalAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
		    }
		});
		
		panel.add(button);
		panel.add(fileLabel);
		
	}

	public JFileChooser getInput() {
		return input;
	}

	public void setInput(JFileChooser input) {
		this.input = input;
	}

}