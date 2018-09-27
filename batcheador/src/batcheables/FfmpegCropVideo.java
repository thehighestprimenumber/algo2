package batcheables;

import java.time.LocalTime;

import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;

//ffmpeg -ss <start> -i <SrcFile> -t <duration> -c copy <DstFile>
@Batcheable(name = "ffmpegCropVideo", command = "ffmpeg")
public class FfmpegCropVideo implements Ibatcheable {

	@Parameter(flag = "-ss", label = "inputStart", control = "gui.TextControl", optional = false)
	public LocalTime start;
	
	@Parameter(flag = "-i", label = "inputVideo", control = "gui.FileChooserOpenControl", optional = false)
	public String inputVideo;

	@Parameter(flag = "-t", label = "inputDuration", control = "gui.TextControl", optional = false)
	public LocalTime duration;

	@Parameter(flag = "-c", label = "destination", control = "gui.FileChooserSaveControl", optional = false)
	public String outputVideo;
	
}