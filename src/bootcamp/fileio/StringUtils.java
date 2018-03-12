package bootcamp.fileio;

public class StringUtils
{
    public static boolean isPalindrom(String test) {
        String reverseTest = "";
        for(int i = test.length ()-1;i>=0;i--) {
            reverseTest = reverseTest + test.charAt (i);
        }
        
        return test.equalsIgnoreCase (reverseTest);
    }
}
