package fizzbuzz;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringPractice {

    @Test(description = "Reverse a String")
    public void testStringReversal() {
        Assert.assertEquals(reverseStr("india"), "aidni");
        Assert.assertEquals(reverseStr("racecar"), "racecar");
        Assert.assertNotEquals(reverseStr("sandeep"), "sandeep");
    }

    private String reverseStr(String input){
        String output = "";
        int strLength = input.length();
        for (int i = 0; i < strLength; i++) {
            output = output + input.charAt(strLength-i-1);
            // OR
            // output = input.charAt(i) + output;
        }
        return output;
    }

    @Test(description = "Reverse each word of a given string")
    public void testSentenceReversal(){
        Assert.assertEquals(reverseEachWord("Java is good programming langauges"),"avaJ si doog gnimmargorp seguagnal");
    }

    private String reverseEachWord(String inputStr) {
        String[] inputStrArr = inputStr.split(" ");
        int worldCount = inputStrArr.length;
        String[] outputStrArr = new String[worldCount];

        for (int i = 0; i < worldCount; i++) {
            outputStrArr[i] = reverseStr(inputStrArr[i]);
        }
        return  String.join(" ", outputStrArr);
    }

    @Test(description = "Count occurrences of Each in a string")
    public void printDuplicateChars() {
        String input = "sandeep sethi";
        input = input.toLowerCase();

        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if(charMap.containsKey(currentChar)){
                charMap.put(currentChar, charMap.get(currentChar)+1);
            }else {
                charMap.put(currentChar, 1);
            }
        }

        charMap.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });
    }

    @Test(description = "Print duplicate characters in a string in Java 8+")
    public void printDuplicateChars_J8() {
        String input = "sandeep sethi";
        input = input.toLowerCase();
        Map<Character, Integer> charMap = new HashMap<>();

        // Use Java 8's Map.merge for counting occurrences
        input.chars()                         // Returns the Stream of ints representing the chars
                .mapToObj(c -> (char) c) // Streams the characters as objects
                .forEach(
                        c -> charMap.merge(c, 1, Integer::sum) //Concise and thread-safe way to count or increment.
                );

        // Print only duplicate characters
        charMap.forEach((key, value) -> {
            if (value > 1 && key != ' ') {     // option to skip spaces
                System.out.println("Key: " + key + ", Value: " + value);
            }
        });
    }

}
