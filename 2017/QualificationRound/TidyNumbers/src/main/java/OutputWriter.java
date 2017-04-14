import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RNiranjan on 4/8/2017.
 */
public class OutputWriter {

    private final File file;
    private int counter = 1;
    private List<String> outputs = new ArrayList<>();

    public OutputWriter(File file) {
        this.file = file;
    }

    public void write(long result)
    {
        String output = "Case #" + counter + ": " + result;
        outputs.add(output);
        counter++;
    }

    public void done() throws IOException {
        Files.write(file.toPath(), outputs);
    }
}
