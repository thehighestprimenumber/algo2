package batcheables;

import batcheador.Batcheable;
import batcheador.Parameter;
import core.Ibatcheable;

@Batcheable(name = "PingServer", command = "ping")
public class PingServer implements Ibatcheable {

    @Parameter(label = "server", control = "gui.TextControl", optional = false)
    public String server = "www.google.com";
}
