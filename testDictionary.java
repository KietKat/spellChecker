import java.io.*;

public class testDictionary {
    public static void main(String[] args) throws Exception {
        File file =new File("words.txt");
        SpellChecker checker= new SpellChecker(file);
        checker.correctlySpelled("eft");
        checker.correctlySpelled("bul");
        checker.correctlySpelled("jlane");
        checker.correctlySpelled("ope");
        checker.correctlySpelled("lov");
    }    
}
