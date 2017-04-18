import java.io.File;
import java.io.IOException;

/**
 * Created by RNiranjan on 4/8/2017.
 */
public class TidyNumbers {
    public static void main(String[] args) throws IOException {
        if(args.length != 2)
        {
            System.out.println("Please provide input file and output file locations");
            System.exit(0);
        }
        File input = new File(args[0]);
        File output = new File(args[1]);
        InputReader inputReader = new InputReader(input);
        OutputWriter outputWriter = new OutputWriter(output);
        new TidyNumbers(inputReader, outputWriter).process();
    }

    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public TidyNumbers(InputReader inputReader, OutputWriter outputWriter)
    {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void process() throws IOException {
        InputReader.InputIterator inputIterator = inputReader.readAll();
        while(inputIterator.hasNext())
        {
            long curInput = inputIterator.next();
            long result = processActually(curInput);
            outputWriter.write(result);
        }
        outputWriter.done();
    }

    private long processActually(long curInput) {
        String inputAsString = Long.toString(curInput);
        int inputLen = inputAsString.length();
        StringBuilder inputReversed = new StringBuilder(inputAsString).reverse();
        //StringBuilder output = new StringBuilder();
        for(int i = 0; i < inputLen - 1; i++)
        {
            char curChar = inputReversed.charAt(i);
            char nextChar = inputReversed.charAt(i + 1);
            if(curChar >= nextChar)
            {
                //nothing to do
            }
            else
            {
                inputReversed.setCharAt(i, '9');
                //set all visited chars to '9' as we have encountered one zero
                for(int j = i - 1; j >= 0; j--)
                {
                    inputReversed.setCharAt(j, '9');
                }
                if(nextChar != '0')
                {
                    inputReversed.setCharAt(i + 1, subtractOneFrom(nextChar));
                }
                else
                {
                    inputReversed.setCharAt(i + 1, '9');
                    //i need to borrow one from non-zero value. loop till i find one. borrowing all the way.
                    for(int j = i + 2; j < inputLen - 1; j++)
                    {
                        if(inputReversed.charAt(j) != '0')
                        {
                            inputReversed.setCharAt(j, subtractOneFrom(inputReversed.charAt(j)));
                            break;
                        }
                        else
                        {
                            inputReversed.setCharAt(j, '9');
                        }
                    }
                }
            }
        }
        return Long.parseLong(inputReversed.reverse().toString());
    }

    private char subtractOneFrom(char nextChar) {
        int radix = 10;
        return Character.forDigit(getAsInt(nextChar) - 1, radix);
    }

    private int getAsInt(char nextChar) {
        return Integer.parseInt("" + nextChar);
    }
}
