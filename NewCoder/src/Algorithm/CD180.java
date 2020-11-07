package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 通过先序和中序数组生成后序数组
 * @author: Desmand
 * @time: 2020/11/5 12:06 下午
 * 题目描述
 * 给出一棵二叉树的先序和中序数组，通过这两个数组直接生成正确的后序数组。
 * 输入描述:
 * 第一行一个整数 n，表示二叉树的大小。
 * <p>
 * 第二行 n 个整数 a_i，表示二叉树的先序遍历数组。
 * <p>
 * 第三行 n 个整数 b_i，表示二叉树的中序遍历数组。
 * 输出描述:
 * 输出一行 n 个整数表示二叉树的后序遍历数组。
 */

public class CD180 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] read(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();

        }
        return arr;
    }

    public static int[] getPosArray(int[] pre, int[] in) {
        int len = pre.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        int[] pos = new int[len];
        setPos(pre, 0,len-1, in, 0,len-1, pos, len - 1, map);
        return pos;
    }

    public static int setPos(int[] p, int pi, int pj, int[] n, int ni, int nj, int pos[], int si, HashMap<Integer, Integer> map) {
        if (pi > pj) return si;
        pos[si--] = p[pi];
        int i = map.get(p[pi]);
        si = setPos(p, pj - nj + i + 1, pj, n, i + 1, nj, pos, si, map);
        return setPos(p, pi + 1, pi + i - ni, n, ni, i - 1, pos, si, map);
    }

    public static void main(String[] args) {
        int n = nextInt();
        int pre[] = read(n);
        int in[] = read(n);
        int[] pos = getPosArray(pre, in);
        for (int i : pos) {
            System.out.print(i + " ");
        }

    }
}
