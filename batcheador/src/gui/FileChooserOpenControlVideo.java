package gui;


import java.lang.reflect.Field;

import javax.swing.filechooser.FileNameExtensionFilter;

import core.Ibatcheable;

public class FileChooserOpenControlVideo extends FileChooserOpenControl{
	public FileChooserOpenControlVideo(Field f, Ibatcheable b) {
		super(f,b);
		input.addChoosableFileFilter(new FileNameExtensionFilter("Video file", "mpg", "mov", "wmv", "rm", "mp4", "webm", "avi"));
		input.setAcceptAllFileFilterUsed(false);
	}


}