package batcheables;

import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;

// ffmpeg -i example.mkv -c copy -an example-nosound.mkv

@Batcheable(name = "FfmpegMuteVideo", command = "ffmpeg")
public class FfmpegMuteVideo implements Ibatcheable {

	@Parameter(flag = "-i", label = "inputVideo", control = "gui.TextControl", optional = false)
	public String inputVideo;

	@Parameter(flag = "-c")
	public String copy = "copy";

	@Parameter(flag = "-an", label = "outputVideo", control = "gui.TextControl", optional = false)
	public String outputVideo;
	
}