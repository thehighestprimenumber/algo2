package batcheables;

import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;

// ffmpeg -i example.mkv -c copy -an example-nosound.mkv

@Batcheable(name = "ffmpeg - Mute Video", command = "ffmpeg")
public class FfmpegMuteVideo implements Ibatcheable {

	@Parameter(flag = "-i", label = "inputVideo", control = "gui.FileChooserOpenControl", optional = false)
	public String inputVideo;

	@Parameter(flag = "-c")
	public String copy = "copy";

	@Parameter(flag = "-an", label = "outputVideo", control = "gui.FileChooserSaveControl", optional = false)
	public String outputVideo;
	
}