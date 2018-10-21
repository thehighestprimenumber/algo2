package gui;


import java.lang.reflect.Field;

import javax.swing.filechooser.FileNameExtensionFilter;

import core.Ibatcheable;

public class FileChooserOpenControlImg extends FileChooserOpenControl{
	public FileChooserOpenControlImg(Field f, Ibatcheable b) {
		super(f,b);
		input.addChoosableFileFilter(new FileNameExtensionFilter("Image file", "jpg", "jpeg", "png", "gif", "bmp", "tif"));
		input.setAcceptAllFileFilterUsed(false);
	}

}