package gui;


import java.lang.reflect.Field;

import javax.swing.filechooser.FileNameExtensionFilter;

import core.Ibatcheable;

public class FileChooserOpenControlAudio extends FileChooserOpenControl{
	public FileChooserOpenControlAudio(Field f, Ibatcheable b) {
		super(f,b);
		input.addChoosableFileFilter(new FileNameExtensionFilter("Audio file", "wav", "aif", "mp3", "mid"));
		input.setAcceptAllFileFilterUsed(false);
	}
}