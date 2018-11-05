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

public class FileChooserSaveControlVideo extends BatchControl{
	private JFileChooser input;
	private JButton button;
	private JLabel fileLabel;
	public FileChooserSaveControlVideo(Field f, Ibatcheable b) {
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
							// Agrego extension por default
							if (getFileExtension(file) == ""){
								 file = new File(file.toString() + ".mp4");  // append .mp4 	
							} 
							field.set(b, file.getAbsolutePath());
							fileLabel.setText(file.getAbsolutePath());
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
	
	private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

}
