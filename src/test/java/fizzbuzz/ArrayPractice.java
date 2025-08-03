package fizzbuzz;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayPractice {

    @Test(description = "Find common elements between two arrays")
    public void findCommonElements(){
        int[] arr1 = { 1,2,3,4,5};
        int[] arr2 = { 6,7,8,4,5};
        HashSet<Integer> commonSet = new HashSet<>();

       /* for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i] == arr2[j]){
                    commonSet.add(arr1[i]);
                }
            }
        }*/

        for(int i : arr1){
            for(int j: arr2){
                if(i == j)
                    commonSet.add(i);
            }
        }
        commonSet.forEach(System.out::println);
    }

    @Test(description = "Find first and last element of Arraylist")
    public void findFirstAndLastElementOfList() {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("Delhi");
        strList.add("Noida");
        strList.add("Gurgaon");
        strList.add("Mumbai");

        System.out.printf("First element of list is - %s, and last element is = %s%n",
                strList.getFirst(), strList.getLast());

        System.out.println("First element of arraylist: " + strList.get(0));
        System.out.println("Last element of arraylist: " + strList.get(strList.size() -1));

    }

    @Test(description = "Sort an array without using in-built method")
    public void testArraySort(){

        Assert.assertEquals(selectionSort(new int[] {5, 7, -9, 3, 7, 2, 9}), new int[] { -9, 2, 3, 5, 7, 7, 9});

        System.out.println("Using inbuilt method............");
        int[] arr = new int[] {3, 8, 0, 6, 3};
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    /**
     * This is a simple version of the Selection Sort or closely resembles a Bubble Sort.
     * <br>The main idea: For every position in the array, it looks for smaller values later in the array and swaps them forward.<br>
     * <br>Efficiency: This method has time complexity O(n²), which may be slow for large arrays.
     * <br>In-Place: It sorts the original array, without using extra arrays.
     * <br>Not Stable: If there are duplicate values, their order may not be preserved.
     * @param arr
     * @return
     */
    private int[] selectionSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    @Test(description = "Remove duplicates from an Array")
    public void removeDuplicates(){
        int[] arr = {6,7,3,6,9,7};
        HashSet<Integer> setArr = new HashSet<>();
        for(int e : arr){
            setArr.add(e);
        }

        Object[] distinctArr = setArr.toArray(); //Note that toArray() method of a Set returns an Object array
        Arrays.stream(distinctArr).forEach(System.out::println);

        //If we want int array do following:
        int[] intArr = new int[setArr.size()];
        int i = 0;
        for(int num : setArr){
            intArr[i++] = num;
        }
        System.out.println("----------------");
        Arrays.stream(intArr).forEach(System.out::println);
    }

}
