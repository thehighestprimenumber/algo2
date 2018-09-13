package batcheables;

import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;

@Batcheable(name = "ffmpegVideo2Audio")
public class FfmpegVideo2Audio implements Ibatcheable {

	@Parameter(flag = "-i", label = "inputVideo", control = "gui.TextControl", optional = false)
	private String inputVideo;

	@Parameter(flag = "-i", label = "inputVideo", control = "gui.TextControl", optional = false)
	private String inputAudio;

	@Parameter(flag = "-o", label = "inputVideo", control = "gui.TextControl", optional = false)
	private String output;
	
}

