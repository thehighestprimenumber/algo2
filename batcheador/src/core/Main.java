package core;

import java.util.ArrayList;
import java.util.List;

import batcheables.FfmpegCropVideo;
import batcheables.FfmpegMuteVideo;
import batcheables.FfmpegVideo2Audio;
import batcheables.PingServer;
import gui.MainWindow;

public class Main {
	
	public static void main(String[] args) {
		List<Ibatcheable> aplicaciones = new ArrayList<Ibatcheable>();
		aplicaciones.add(new FfmpegVideo2Audio());
		aplicaciones.add(new FfmpegCropVideo());
		aplicaciones.add(new FfmpegMuteVideo());
        aplicaciones.add(new PingServer());
		new MainWindow(aplicaciones);
	}
}
