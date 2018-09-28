package batcheables;

import java.time.LocalTime;

import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;

//ffmpeg -ss <start> -i <SrcFile> -t <duration> -c copy <DstFile>
@Batcheable(name = "ffmpegCropVideo", command = "ffmpeg")
public class FfmpegCropVideo implements Ibatcheable {

	@Parameter(flag = "-ss", label = "Start time", control = "gui.TextControl", optional = false)
	public LocalTime start;
	
	@Parameter(flag = "-i", label = "Video Imput", control = "gui.FileChooserOpenControl", optional = false)
	public String inputVideo;

	@Parameter(flag = "-t", label = "Video duration", control = "gui.TextControl", optional = false)
	public LocalTime duration;

	@Parameter(flag = "-c", label = "Output file", control = "gui.FileChooserSaveControl", optional = false)
	public String outputVideo;
	
}