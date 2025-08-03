package fizzbuzz;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

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
            // output = output + input.charAt(strLength-i-1);
            // OR
             output = input.charAt(i) + output;
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
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem1 = str.substring(0,i);
                String rem2 = str.substring(i+1);
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
        for( int i = 0; i < inputLength; i++) {
            if( input.charAt(i) != input.charAt(inputLength-1-i) )
                return  false;
        }
        return true;
    }

    @Test(description = "determine if Two Strings are Anagrams")
    public void testAnagram(){
        Assert.assertTrue(areAnagrams("listen", "silent"));
    }

    private boolean areAnagrams(String str1, String str2) {
        char[] arrChar1 = str1.toCharArray();
        char[] arrChar2 = str2.toCharArray();
        Arrays.sort(arrChar1);
        Arrays.sort(arrChar2);

        return Arrays.equals(arrChar1, arrChar2);
    }

    @Test(description = "Count Vowels and Consonants in a given string")
    public void testCountOfVowelsAndConsonents(){
        Assert.assertEquals(getVowelCount("Hello world"), 3);
        Assert.assertEquals( "Hello world".replaceAll(" ", "").length() - getVowelCount("Hello world"), 7);
    }

    private int getVowelCount(String input){
        input = input.toLowerCase();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
           char c = input.charAt(i);
           if( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ){
                count++;
           }
        }
        return count;
    }

    @Test(description = "Print unique characters")
    public void printUniqueChars(){
        String str = "Java Automation";
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Count occurrences of each character
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        System.out.print("Unique characters: ");
        // Print characters with count 1 (unique)
        for (char c : str.toCharArray()) {
            if (charCountMap.get(c) == 1) {
                System.out.print(c + " ");
            }
        }
    }
    //Output: Unique characters: J v   A u m i n

    @Test(description = "Print unique characters")
    public void printUniqueChars2(){
        String str = "Java Automation";
        int[] charCount = new int[256]; // For all ASCII characters

        // Count occurrences of each character
        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i)]++;
        }

        System.out.print("Unique characters: ");
        // Print characters that appear only once (unique)
        for (int i = 0; i < str.length(); i++) {
            if (charCount[str.charAt(i)] == 1) {
                System.out.print(str.charAt(i) + " ");
            }
        }
    }
    //Output: Unique characters: J v   A u m i n

    @Test(description = "Remove space from a string")
    public void testSpaceRemoval(){
        Assert.assertEquals(removeSpaces("Hello world"), "Helloworld");
        Assert.assertEquals(removeSpaces("Welcome to Java World"), "WelcometoJavaWorld");
    }

    private String removeSpaces(String input){
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if( c != ' ' )
                output = output + c;
        }
        return output;
    }

    @Test(description = "print each letter twice from a given string")
    public void printTwice(){
        String input = "hello";
        String output = "";

         for (int i = 0; i < input.length(); i++) {
             char currChar = input.charAt(i);
             output = output + currChar +currChar;
         }

         System.out.println(output);
     }

     @Test(description = "swap two string without using 3rd variable")
    public void swapStr(){
        String str1 = "hello";
        String str2 = "world";

         System.out.printf("Before swapping: str1=%s , str2=%s%n", str1, str2);
         str1 = str1 + str2;
         str2 = str1.replaceAll(str2, "");
         str1 = str1.replaceAll(str2, "");
         System.out.printf("After swapping: str1=%s , str2=%s%n", str1, str2);
     }

    public void swapStr2() {
        String str1 = "hello";
        String str2 = "world";

        System.out.printf("Before swapping: str1=%s , str2=%s%n", str1, str2);

        str1 = str1 + str2;
        str2 = str1.substring(0, str1.length() - str2.length());  // Extract the initial part (original str1) from the concatenated string
        str1 = str1.substring(str2.length());    // Extract the remaining part (original str2) from the concatenated string
        System.out.printf("After swapping: str1=%s , str2=%s%n", str1, str2);
    }

    @Test(description = "gives Output: a2b2c3d2 for the Input String Str = “aabbcccdd”")
    public void testCharCount(){
        Assert.assertEquals(getCharCount("aabbcccdd"), "a2b2c3d2");
        Assert.assertEquals(getCharCount("aabbcccdddaa"), "a2b2c3d3a2");
    }

    private String getCharCount(String input) {
        String output = "";
        int continousCounter = 1;
        output = output + input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            if( input.charAt(i) == input.charAt(i-1))
                continousCounter++;
            else {
                output = output + continousCounter + input.charAt(i);
                continousCounter = 1;
            }
        }

        return output+continousCounter;
    }

    @Test(description = "gives two Output: 'abcde', 'ABCDE' for the Input String Str = 'aABCbcEDed'")
    public void testSeparateChars(){
        String input = "aABCbcEDed";
        String lcStr = "";
        String ucStr = "";

        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            if(currChar >= 'a' && currChar <= 'z')
                lcStr = lcStr + currChar;
            else if (currChar >= 'A' && currChar <= 'Z')
                ucStr = ucStr + currChar;
            else
                continue;
        }

        System.out.printf("%s%n%s", lcStr, ucStr);

    }

    @Test(description = "gives two Output: 'abcde', 'ABCDE' for the Input String Str = 'aABCbcEDed'")
    public void testSeparateChars2(){
        String input = "aABCbcEDed";
        StringBuilder lowerCase = new StringBuilder();
        StringBuilder upperCase = new StringBuilder();

        for(char ch : input.toCharArray())
        {
            if(Character.isLowerCase(ch))
                lowerCase.append(ch);
            else
                upperCase.append(ch);

        }

        System.out.printf("%s%n%s", lowerCase, upperCase);

    }

    @Test(description = "find the length of longest substring without repeating characters")
    public void testLengthOfLongestSubstring() {
        Assert.assertEquals(lengthOfLongestSubstring("abcabcbb"),3);
        Assert.assertEquals(lengthOfLongestSubstring("bbbbb"),1);
        Assert.assertEquals(lengthOfLongestSubstring("pwwkew"),3);
        Assert.assertEquals(lengthOfLongestSubstring(""),0);
    }

    private int lengthOfLongestSubstring(String input){
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;

        for (int right = 0; right < input.length(); right++) {
            char c = input.charAt(right);

            // If the character is already in the map, shift the left pointer
            if (map.containsKey(c)) {
                left = Math.max(map.get(c) + 1, left);
            }

            // Update character's last seen index
            map.put(c, right);

            // Update max length if needed
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

}