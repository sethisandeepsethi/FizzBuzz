package fizzbuzz;

import org.testng.Assert;
import org.testng.annotations.Test;


public class NumberPractice {

    @Test(description = "calculate the sum of digits of a number")
    public void testSumOfDigits(){
        Assert.assertEquals(sumOfDigits(12345),15);
        Assert.assertEquals(sumOfDigits(0),0);
    }

    private int sumOfDigits(int num) {
        int sum = 0;

        do {
            sum = sum + num%10;
            num /= 10;
        }while(num > 0);

        return sum;
    }

    @Test(description = "find Palindrome number")
    public void testPalindromeNumber(){
        Assert.assertTrue(isPalindrome(123321));
        Assert.assertTrue(isPalindrome(-131));
        Assert.assertFalse(isPalindrome(-123456));
    }

    private boolean isPalindrome(int num){
        int ori = num;
        if (ori < 0 )
            num *= -1;

        int reverse =0;
        int lastDigit;

        do {
            lastDigit = num % 10;
            reverse = reverse * 10 +lastDigit;
            num /= 10;
        }while (num > 0);

        if(ori < 0 )
            reverse *= -1;

        return ori == reverse;
    }

    @Test(description = "find number of digits in given number")
    public void testDigitCount(){
        Assert.assertEquals(getDigitCount(12345),5);
        Assert.assertEquals(getDigitCount(11),2);
        Assert.assertEquals(getDigitCount(0),1);
        Assert.assertEquals(getDigitCount(-1234),4);
    }

    private int getDigitCount(int num){
        int digit = 0;

        if(num < 0)
            num *= -1;

        do {
            num /= 10;
            digit++;
        }while (num > 0);
        return digit;
    }

    @Test(description = "find Armstrong Number")
    public void testArmstongNumber(){
        Assert.assertTrue(isArmStrong(153));
        Assert.assertTrue(isArmStrong(1634));
        Assert.assertTrue(isArmStrong(93084));
        Assert.assertFalse(isArmStrong(1635));
    }

    private boolean isArmStrong(int num) {
        int ori = num;
        int digits = 0;
        do {
            digits++;
            num = num / 10;
        }while ( num > 0);

        int lastDigit;
        int sumOfDigits = 0;
        num = ori;
        do {
            lastDigit = num % 10;
            sumOfDigits = sumOfDigits + (int)Math.pow(lastDigit, digits);
            num = num/10;
        }while ( num > 0);
        System.out.printf("Sum of digits = %d %n", sumOfDigits);

        return sumOfDigits == ori;
    }

    @Test(description = "Reverse a number")
    public void testReverseNum(){
        long num = 123456789;
        System.out.printf("Reverse of %d is %d:",num, reverseNum(num));
    }

    private long reverseNum(long num) {
        long reverse = 0;
        do {
            reverse = reverse * 10;
            reverse = reverse + num % 10;
            num = num / 10;
        }while(num > 0);

        return reverse;
    }

    @Test(description = "Find Factorial on given Number")
    public void factorial(){
        int num = 16;
        long fact = 1;
        System.out.printf("Factorial of %d is ", num);

        for(int i = num; i > 0; i--) {
            fact = fact * i;
        }
        System.out.printf("%d", fact);
    }

    @Test(description = "swap two numbers without using third variable")
    public void swapInts(){
        int i = 3, j = 6;
        System.out.printf(" i = %d and j = %d%n",i,j);

        i = i + j;
        j = i - j; // i + j - i = j
        i = i - j; // i + j - j = i

        System.out.printf(" i = %d and j = %d%n",i,j);
    }

    @Test(description = "find Fibonacci series upto a given number range")
    public void fibonacchi(){
        int limit = 10;
        int i = 0;
        int j = 1;
        System.out.printf("%d %d",i,j);
        int k;
        for(int count = 1; count < limit-1; count++){
            k = i + j;
            System.out.printf(" %d", k);
            i = j;
            j = k;
        }
    }

    @Test(description = "find Prime number")
    public void testPrime(){
        Assert.assertTrue(isPrime(2));
        Assert.assertTrue(isPrime(1));
        Assert.assertFalse(isPrime(4));
        Assert.assertTrue(isPrime(79));
        Assert.assertFalse(isPrime(100));
    }

    private boolean isPrime(int n) {
        System.out.printf("Checking if %d is Prime%n", n);
        if(n == 0 || n == 1 )
            return true;
        for(int i = 2; i <= n/2; i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }

}