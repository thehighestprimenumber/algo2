package batcheables;

import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;

//ffmpeg -i <SrcFile> -vf "transpose=2,transpose=2" -codec:a copy <DstFile>
@Batcheable(name = "ffmpeg - Rotate Video", command = "ffmpeg")
public class FfmpegRotateVideo implements Ibatcheable {

	@Parameter(flag = "-vf", label = "Rotation", control = "gui.AngleSpinnerControl", optional = false)
	public String rotation;
	
	@Parameter(flag = "-i", label = "Video Imput", control = "gui.FileChooserOpenControlVideo", optional = false)
	public String inputVideo;

	@Parameter(flag = "", label = "Output file", control = "gui.FileChooserSaveControlVideo", optional = false)
	public String outputVideo;
	
}