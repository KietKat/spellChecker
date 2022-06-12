import java.io.FileNotFoundException;
import java.io.*;


public class SpellChecker{
    private final dictionary dict = new dictionary();

    //take file, hash every word to make hash map
    SpellChecker(File file) throws FileNotFoundException
    {
        dict.createDictionary(file);
    }

    public void correctlySpelled(String word) throws FileNotFoundException
    {
        if (dict.check(word)== true) {System.out.println("No mistake!");}
        else
        {
            System.out.println(suggestion(word));
        }
    }

    //idea: alternate the words, hash the word again to find if the word appear in the map
    private String suggestion(String word) throws FileNotFoundException
    {
        return "Sugestion:"+ addBeg(word) +addEnd(word) +delBeg(word) +delEnd(word)+ switchAdjacent(word) ;
    }

    //add 1 letter to the beginning
    private String addBeg(String word) throws FileNotFoundException
    {
        String sug = "";
        String temp;
        //run through the alphabet
        for (char c= 'a'; c <='z' ; c++)
        {
            temp = c+ word;
            if (dict.check(temp)== true) {sug += " " + temp; }
        }
        return sug;
    }

    //add 1 letter to the end of the word
    private String addEnd(String word) throws FileNotFoundException
    {
        String sug = "";
        String temp;
        //run through the alphabet, add to the end of the word
        for (char c= 'a'; c <='z' ; c++)
        {
            temp = word + c;
            if (dict.check(temp)== true) {sug += " " + temp; }
        }
        return sug;
    }

    //delete 1 character at the beginning
    private String delBeg(String word) throws FileNotFoundException
    {
        String temp=word.substring(1,word.length());
        if (dict.check(temp)== true) {return " " + temp;} 
        return "";
    }

    //delete 1 character at the end
    private String delEnd(String word) throws FileNotFoundException
    {
        String temp=word.substring(0,word.length()-1); 
        if (dict.check(temp)== true) {return " " + temp;} 
        return "";
    }

    //change position between 2 adjacent characters
    private String switchAdjacent(String word) throws FileNotFoundException
    {
        String sug="";
        String adder;
        System.out.println(word);
        for (int i =0; i < word.length()-1; i++)
        {
            char[] ch= word.toCharArray();
            char temp = ch[i];
            ch[i] = ch[i + 1];
            ch[i + 1] = temp;
            adder = new String(ch);
            if (dict.check(adder)) sug += " " + adder;
        }
        return sug;
    }
}
