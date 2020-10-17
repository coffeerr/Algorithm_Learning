package LeetCode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    public boolean canMakeArithmeticProgression(int[] arr) {
        sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int m = arr[i + 2] - arr[i + 1];
            int n = arr[i + 1] - arr[i];
            if (m != n) return false;
        }
        return true;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {3,5,1};

        boolean ret = new Solution().canMakeArithmeticProgression(arr);

        String out = booleanToString(ret);

        System.out.print(out);
    }
}
