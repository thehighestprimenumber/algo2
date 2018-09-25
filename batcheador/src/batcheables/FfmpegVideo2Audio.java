package batcheables;

import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;

@Batcheable(name = "ffmpegVideo2Audio")
public class FfmpegVideo2Audio implements Ibatcheable {

	@Parameter(flag = "-i", label = "Video Input", control = "gui.FileChooserControl", optional = false)
	public String inputVideo;

	@Parameter(flag = "-i", label = "Audio Input", control = "gui.TextControl", optional = false)
	public String inputAudio;

	@Parameter(flag = "-o", label = "Output file", control = "gui.TextControl", optional = false)
	public String output;
	
}

