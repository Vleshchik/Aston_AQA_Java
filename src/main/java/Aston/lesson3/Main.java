package Aston.lesson3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(compareSumOfNumbers(35, 6));

        System.out.println(checkPositiveNumber(0));

        System.out.println(checkNegativeNumber(-5));

        printTextNTimes("I learn Java", 5);

        System.out.println(checkLeapYear(1200));

        switchOnesAndZeros();

        fillArrayOneToHundred();

        doubleNumberInArray();

        fillTwoDimensionalArray(6);

        fillArrayOneToHundred(7, 1);
    }
    public static boolean compareSumOfNumbers(int a, int b) {
        int c = a + b;
        return c >= 10 && c <= 20;
    }
    public static boolean checkPositiveNumber(int a) {

        return a >= 0;
    }
    public static boolean checkNegativeNumber(int a) {

        return a < 0;
    }
    public static void printTextNTimes(String txtToPrint, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(txtToPrint);
        }
    }
    public static boolean checkLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else return year % 4 == 0;
    }
    public static void switchOnesAndZeros() {
        int[] arr = {0, 1, 1, 0, 0, 1, 1, 1, 0, 0 ,0, 1};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void fillArrayOneToHundred() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (i + 1);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void doubleNumberInArray(){
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2 ,4 ,8, 9, 1};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void fillTwoDimensionalArray(int n){
        int[][] table = new int[n][n];
        int counter = n - 1;
        for (int i = 0; i < n; i++){
            table[i][i] = 1;
            table[i][counter-i] = 1;
            }
        System.out.println(Arrays.deepToString(table).replace("], ", "]\n"));
    }
    public static void fillArrayOneToHundred(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        System.out.println(Arrays.toString(arr));
    }
}
