package batcheables;

import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;

//ffmpeg -ss <start> -i <SrcFile> -t <duration> -c copy <DstFile>
@Batcheable(name = "ffmpeg - Crop Video", command = "ffmpeg")
public class FfmpegCropVideo implements Ibatcheable {

	@Parameter(flag = "-ss", label = "Start time", control = "gui.DurationSpinnerControl", optional = false)
	public String start;
	
	@Parameter(flag = "-i", label = "Video Imput", control = "gui.FileChooserOpenControl", optional = false)
	public String inputVideo;

	@Parameter(flag = "-t", label = "Video duration", control = "gui.DurationSpinnerControl", optional = false)
	public String duration;

	@Parameter(flag = "-c", optional = false)
	public String copy = "copy";
	
	@Parameter(flag = "", label = "Output file", control = "gui.FileChooserSaveControl", optional = false)
	public String outputVideo;
	
}