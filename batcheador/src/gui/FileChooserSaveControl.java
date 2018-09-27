package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import core.Ibatcheable;

public class FileChooserSaveControl extends BatchControl{
	private JFileChooser input;
	private JButton button;
	private JLabel fileLabel;
	public FileChooserSaveControl(Field f, Ibatcheable b) {
		super(f,b);
		
		button = new JButton("Save");
		fileLabel = new JLabel("Select file");
		input = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		input.setDialogTitle("Specify a file to save");
		input.addChoosableFileFilter(new FileNameExtensionFilter("Video file", "mpg", "mov", "wmv", "rm", "mp4", "webm", "avi"));
		input.setAcceptAllFileFilterUsed(false);

		button.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {
				int returnValue = input.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
				    File file = input.getSelectedFile();
					if (file != null) {
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
