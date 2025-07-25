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

    @Test(description = "count the number of words in a string")
    public void testWorldCount(){
        Assert.assertEquals(getWorldCount("Welcome to Java World"), 4);
    }

    private int getWorldCount(String input){
        String[] inputStrArr = input.split(" ");
        return inputStrArr.length;
    }

    @Test(description = "find all permutations of a given string")
    public void printAllPermutations(){
        String input = "abcd"; //abcd

        permutationOf(input,"");

    }

    public void permutationOf(String str, String prefix) {
        System.out.printf("prefix: %s, ", prefix);
        if (str.length() == 0) {
            //System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem1 = str.substring(0,i);
                String rem2 = str.substring(i+1);
                System.out.printf(" str: %s, rem1: %s , rem2: %s%n",str, rem1, rem2);
                String rem = rem1 + rem2;
                permutationOf(rem, prefix + str.charAt(i));
            }
        }
    }

    @Test(description = "find if a string is Palindrome")
    public void testPalindrome(){
        Assert.assertTrue(isPalindrome("madam"));
        Assert.assertTrue(isPalindrome("racecar"));
        Assert.assertTrue(isPalindrome("Was it a car or a cat I saw"));

        Assert.assertFalse(isPalindrome("sandeep"));
    }

    private boolean isPalindrome(String input) {
        input = input.toLowerCase().replaceAll(" ", "");
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            output = output + input.charAt(input.length()-1-i);
        }
        return input.equals(output);
    }

    public boolean isPalindrome2(String input) {
        input = input.toLowerCase().trim().replaceAll(" ", "");
        int inputLength = input.length();
        System.out.printf("Length of %s is %d%n",input, input.length());

        for( int i = 0; i < inputLength; i++) {
            if( input.charAt(i) != input.charAt(inputLength-1-i) )
                return  false;
        }

        return true;
    }






}