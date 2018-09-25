package batcheables;

import java.util.List;

import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;

// ffmpeg -i video.mp4 -af "volume=enable='between(t,5,10)':volume=0, volume=enable='between(t,15,20)':volume=0" ...

@Batcheable(name = "FfmpegMuteVideo", command = "ffmpeg")
public class FfmpegMuteVideo implements Ibatcheable {

	@Parameter(flag = "-i", label = "inputVideo", control = "gui.TextControl", optional = false)
	private String inputVideo;

	@Parameter(flag = "-af", label = "inputAudio", control = "gui.TextControl", optional = false)
	private List<String> sections;
	
}