import java.io.*;
import java.util.Scanner;

public class testDictionary {
    public static void main(String[] args) throws Exception {
        File file =new File("words.txt");
        SpellChecker checker= new SpellChecker(file);
        Scanner scan = new Scanner(System.in); 
        String input;
        while(true)
        {
            System.out.print("Enter a word to check spelling (enter 0 to quit): ");
            input = scan.nextLine();
            if(input.charAt(0) == '0') break;
            checker.correctlySpelled(input);
        }
        scan.close();
    }    
}
