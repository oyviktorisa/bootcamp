package bootcamp.fileio;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FileIOApp
{
    @SafeVarargs
    public static int letterCount (Stream<String> words,
            Predicate<String>... tests)
    {
        Predicate<String> combinedTest = PredicateUtils
                .combinedPredicate (tests);
        return (words.filter (combinedTest).mapToInt (String::length).sum ());
    }

    
    @SafeVarargs
    public static Integer letterCount (String filename,
            Predicate<String>... tests)
    {
        return (FileStreamProcessor.processStream (filename,
                stream -> letterCount (stream, tests)));
    }


    private static void printLetterCountResult (int sum, String message)
    {
        System.out.printf (" %,d total letters in words that %s.%n", sum,
                message);
    }


    public static void main (String[] args)
    {
        String filename = "some.txt";
        List<String> testWords = Arrays.asList ("hi", "hello", "hola");
        System.out.printf ("In list %s:%n", testWords);
        int sum1 = letterCount (testWords.stream (),
                word -> word.contains ("h"), word -> !word.contains ("i"));
        printLetterCountResult (sum1, "contain h but not i");
        System.out.printf ("In file %s:%n", filename);
        int sum2 = letterCount (filename, StringUtils::isPalindrom);
        printLetterCountResult (sum2, "are palindromes");

    }
}
