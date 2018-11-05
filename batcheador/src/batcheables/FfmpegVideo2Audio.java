package batcheables;

import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;
//ffmpeg -i <imageInput> -i <audioInput> -c:v <videoCodec> -c:a <audioCodec> <output>
@Batcheable(name = "ffmpeg - Audio+Img=Video", command = "ffmpeg")
public class FfmpegVideo2Audio implements Ibatcheable {
	@Parameter(flag = "-i", label = "Image Input", control = "gui.FileChooserOpenControlImg", optional = false)
	public String imageInput;

	@Parameter(flag = "-i", label = "Audio Input", control = "gui.FileChooserOpenControlAudio", optional = false)
	public String audioInput;
	
	@Parameter(flag = "-c:a", label = "Audio Codec", control = "gui.TextControl", optional = true)
	public String audioCodec = "copy";

	@Parameter(flag = "", label = "Output file", control = "gui.FileChooserSaveControlVideo", optional = false)
	public String output = "*.mpg";
	
}

