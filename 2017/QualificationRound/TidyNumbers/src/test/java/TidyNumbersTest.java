import org.junit.Test;
import org.mockito.Mockito;
import tidy.InputReader;
import tidy.OutputWriter;
import tidy.TidyNumbers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RNiranjan on 4/8/2017.
 */
public class TidyNumbersTest {

    @Test
    public void shouldComputeCorrectlyForHappyPath() throws IOException {
        long totalTestCases = 1;
        List<Long> inputFromGoogle = Arrays.asList(totalTestCases, 1234L);
        InputReader inputReader = Mockito.mock(InputReader.class);
        Mockito.when(inputReader.readAll()).thenReturn(new InputReader.InputIterator(inputFromGoogle.iterator()));
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        TidyNumbers tidyNumbers = new TidyNumbers(inputReader, outputWriter);
        tidyNumbers.process();

        Mockito.verify(outputWriter).write(1234);
    }

    @Test
    public void shouldComputeCorrectlyForScenario1() throws IOException {
        long totalTestCases = 1;
        List<Long> inputFromGoogle = Arrays.asList(totalTestCases, 1243L);
        InputReader inputReader = Mockito.mock(InputReader.class);
        Mockito.when(inputReader.readAll()).thenReturn(new InputReader.InputIterator(inputFromGoogle.iterator()));
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        TidyNumbers tidyNumbers = new TidyNumbers(inputReader, outputWriter);
        tidyNumbers.process();

        Mockito.verify(outputWriter).write(1239);
    }

    @Test
    public void shouldComputeCorrectlyInARecursiveManner() throws IOException {
        long totalTestCases = 1;
        List<Long> inputFromGoogle = Arrays.asList(totalTestCases, 10003L);
        InputReader inputReader = Mockito.mock(InputReader.class);
        Mockito.when(inputReader.readAll()).thenReturn(new InputReader.InputIterator(inputFromGoogle.iterator()));
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        TidyNumbers tidyNumbers = new TidyNumbers(inputReader, outputWriter);
        tidyNumbers.process();

        Mockito.verify(outputWriter).write(9999);
    }

    @Test
    public void shouldComputeCorrectlyWhenOnlyOneZeroIsPresent() throws IOException {
        long totalTestCases = 1;
        List<Long> inputFromGoogle = Arrays.asList(totalTestCases, 1210L);
        InputReader inputReader = Mockito.mock(InputReader.class);
        Mockito.when(inputReader.readAll()).thenReturn(new InputReader.InputIterator(inputFromGoogle.iterator()));
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        TidyNumbers tidyNumbers = new TidyNumbers(inputReader, outputWriter);
        tidyNumbers.process();

        Mockito.verify(outputWriter).write(1199);
    }

    @Test
    public void shouldComputeCorrectlyWhenOnlyOneZeroIsPresentInMiddleOfNumber() throws IOException {
        long totalTestCases = 1;
        List<Long> inputFromGoogle = Arrays.asList(totalTestCases, 1201L);
        InputReader inputReader = Mockito.mock(InputReader.class);
        Mockito.when(inputReader.readAll()).thenReturn(new InputReader.InputIterator(inputFromGoogle.iterator()));
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        TidyNumbers tidyNumbers = new TidyNumbers(inputReader, outputWriter);
        tidyNumbers.process();

        Mockito.verify(outputWriter).write(1199);
    }

    @Test
    public void shouldBorrowFromNonZeroNumber() throws IOException
    {
        long totalTestCases = 1;
        List<Long> inputFromGoogle = Arrays.asList(totalTestCases, 1208L);
        InputReader inputReader = Mockito.mock(InputReader.class);
        Mockito.when(inputReader.readAll()).thenReturn(new InputReader.InputIterator(inputFromGoogle.iterator()));
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        TidyNumbers tidyNumbers = new TidyNumbers(inputReader, outputWriter);
        tidyNumbers.process();

        Mockito.verify(outputWriter).write(1199);
    }

    @Test
    public void shouldComputeCorrectlyIfAllCharsAreZeroExceptOne() throws IOException
    {
        long totalTestCases = 1;
        List<Long> inputFromGoogle = Arrays.asList(totalTestCases, 100000L);
        InputReader inputReader = Mockito.mock(InputReader.class);
        Mockito.when(inputReader.readAll()).thenReturn(new InputReader.InputIterator(inputFromGoogle.iterator()));
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        TidyNumbers tidyNumbers = new TidyNumbers(inputReader, outputWriter);
        tidyNumbers.process();

        Mockito.verify(outputWriter).write(99999);
    }

    @Test
    public void shouldComputeCorrectlyIfZeroIsInMiddleOfANumber() throws IOException
    {
        long totalTestCases = 1;
        List<Long> inputFromGoogle = Arrays.asList(totalTestCases, 120918L);
        InputReader inputReader = Mockito.mock(InputReader.class);
        Mockito.when(inputReader.readAll()).thenReturn(new InputReader.InputIterator(inputFromGoogle.iterator()));
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        TidyNumbers tidyNumbers = new TidyNumbers(inputReader, outputWriter);
        tidyNumbers.process();

        Mockito.verify(outputWriter).write(119999);
    }

    @Test
    public void shouldComputeCorrectlyForMultipleNumbers() throws IOException
    {
        long totalTestCases = 5;
        List<Long> inputFromGoogle = Arrays.asList(totalTestCases, 120918L, 1000L, 1234L, 869L, 54321L);
        InputReader inputReader = Mockito.mock(InputReader.class);
        Mockito.when(inputReader.readAll()).thenReturn(new InputReader.InputIterator(inputFromGoogle.iterator()));
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        TidyNumbers tidyNumbers = new TidyNumbers(inputReader, outputWriter);
        tidyNumbers.process();

        Mockito.verify(outputWriter).write(119999);
        Mockito.verify(outputWriter).write(999);
        Mockito.verify(outputWriter).write(1234);
        Mockito.verify(outputWriter).write(799);
        Mockito.verify(outputWriter).write(49999);
    }

    @Test
    public void shouldComputeCorrectlyForHighestNumber() throws IOException
    {
        long totalTestCases = 1;
        List<Long> inputFromGoogle = Arrays.asList(totalTestCases, 1000000000000000000L);
        InputReader inputReader = Mockito.mock(InputReader.class);
        Mockito.when(inputReader.readAll()).thenReturn(new InputReader.InputIterator(inputFromGoogle.iterator()));
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        TidyNumbers tidyNumbers = new TidyNumbers(inputReader, outputWriter);
        tidyNumbers.process();

        Mockito.verify(outputWriter).write(999999999999999999L);
    }
}