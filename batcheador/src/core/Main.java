package core;

import batcheables.FfmpegVideo2Audio;
import gui.MainWindow;

public class Main {
	
	public static void main(String[] args) {
		new MainWindow(new FfmpegVideo2Audio());
	}
	
}
