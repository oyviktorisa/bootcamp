package bootcamp.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Stream;

@FunctionalInterface
public interface FileStreamProcessor<T>
{
    T processStream (Stream<String> stream);

    public static <T> T processStream (String filename,
            FileStreamProcessor<T> processor)
    {
        try (Stream<String> lines = Files.lines (Paths.get (filename))) {
            return (processor.processStream (lines));
        } catch (IOException ioe) {
            System.err.println ("Error reading file: " + ioe);
            return (null);
        }
    }
    
}
