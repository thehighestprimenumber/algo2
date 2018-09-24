package batcheables;

import java.time.LocalTime;

import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;

//ffmpeg -ss <start> -i <SrcFile> -t <duration> -c copy <DstFile>
@Batcheable(name = "ffmpegCropVideo")
public class FfmpegCropVideo implements Ibatcheable {

	@Parameter(flag = "-ss", label = "inputStart", control = "gui.TextControl", optional = false)
	private LocalTime start;
	
	@Parameter(flag = "-i", label = "inputVideo", control = "gui.FileChooserControl", optional = false)
	private String inputVideo;

	@Parameter(flag = "-t", label = "inputDuration", control = "gui.TextControl", optional = false)
	private LocalTime duration;

	@Parameter(flag = "-c", label = "destination", control = "gui.FileChooserControl", optional = false)
	private String outputVideo;
	
}