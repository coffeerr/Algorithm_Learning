package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class CD188 {

    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int[][] getRes(int[] arr) {
        int[][] res = new int[arr.length][2];
        // 单调list栈
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek().get(0)]) {
                List<Integer> list = stack.pop();
                int rightIndex = i;
                int leftIndex = (stack.isEmpty()) ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (int j : list) {
                    res[j][0] = leftIndex;
                    res[j][1] = rightIndex;
                }
            }
            if (!stack.isEmpty() && arr[i] == arr[stack.peek().get(0)]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(Integer.valueOf(i));
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> list = stack.pop();
            int leftIndex = (stack.isEmpty()) ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (int j : list) {
                res[j][0] = leftIndex;
                res[j][1] = -1;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int N = nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = nextInt();
        }
        int[][] res = getRes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(res[i][0] + " " + res[i][1]);
            if (i != arr.length - 1) {
                System.out.println("");
            }
        }
    }
}
