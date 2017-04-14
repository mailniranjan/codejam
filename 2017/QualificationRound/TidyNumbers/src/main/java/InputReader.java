import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RNiranjan on 4/8/2017.
 */
public class InputReader {
    private final File file;
    public InputReader(File file)
    {
        this.file = file;
    }

    public InputIterator readAll() throws IOException {
        List<String> allLines = Files.readAllLines(file.toPath());
        List<Long> data = allLines.stream().map(Long::parseLong).collect(Collectors.toList());
        return new InputIterator(data.iterator());
    }

    public static class InputIterator implements Iterator<Long>
    {
        private Iterator<Long> iterator;

        public InputIterator(Iterator<Long> iterator)
        {
            this.iterator = iterator;
            //total testcases is not needed to be read
            iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Long next() {
            return iterator.next();
        }
    }
}
