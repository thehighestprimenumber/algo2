package batcheables;

import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;
//ffmpeg -i input.mp4 -vf "rotate=45*(PI/180),format=yuv420p" \ -metadata:s:v rotate=0 -codec:v libx264 -codec:a copy output.mp4
//Cuando se usa el filtro de rotación, la interpolación bilineal se debe desactivar (usando bilinear = 0) para ángulos divisibles por 90, de lo contrario el resultado puede parecer borroso.

@Batcheable(name = "ffmpeg - Rotate Video", command = "ffmpeg")
public class FfmpegRotateVideo implements Ibatcheable {

	@Parameter(flag = "-i", label = "Video Imput", control = "gui.FileChooserOpenControlVideo", optional = false)
	public String inputVideo;

	@Parameter(flag = "-vf", label = "Rotation", control = "gui.AngleSpinnerControl", optional = false)
	public String rotation;
	// public String rotation = "rotate=%s*PI/180, format = yuv420p";

	@Parameter(flag = "-metadata:s:v", label = "Metadata", control = "gui.TextControl", optional = true)
	public String metadata = "rotate=0";

	@Parameter(flag = "-c:video", label = "Audio Codec", control = "gui.TextControl", optional = true)
	public String videoCodec = "libx264";

	@Parameter(flag = "-c:a", label = "Audio Codec", control = "gui.TextControl", optional = true)
	public String audioCodec = "copy";

	@Parameter(flag = "", label = "Output file", control = "gui.FileChooserSaveControlVideo", optional = false)
	public String outputVideo;

}