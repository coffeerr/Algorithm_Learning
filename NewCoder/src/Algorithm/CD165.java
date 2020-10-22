package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

/**
 * @description: 在二叉树中找到累加和为指定值的最长路径长度
 * @author: Desmand
 * @time: 2020/10/22 11:35 上午
 */

public class CD165 {
    public static class treeNode {
        public int num;
        public int value;
        public treeNode left;
        public treeNode right;

        public treeNode(int num, int value) {
            this.num = num;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static treeNode read() {
        int fa, lth, rth, value;
        fa = nextInt();
        lth = nextInt();
        rth = nextInt();
        value = nextInt();
        treeNode node = new treeNode(fa, value);
        if (lth != 0) {
            node.left = read();
        }
        if (rth != 0) {
            node.right = read();
        }
        return node;
    }

    public static int getMaxLength(treeNode node, int sum, int preSum, int level, int maxLen,
                                   HashMap<Integer, Integer> map) {

        if (node == null) return maxLen;
        int curSum = preSum + node.value;
        if (!map.containsKey(curSum)) {
            map.put(curSum, level);
        }
        if (map.containsKey(curSum - sum)) {
            maxLen = Math.max(maxLen, level - map.get(curSum - sum));
        }
        maxLen = getMaxLength(node.left, sum, curSum, level + 1, maxLen, map);
        maxLen = getMaxLength(node.right, sum, curSum, level + 1, maxLen, map);
        if (level == map.get(curSum)) {
            map.remove(curSum);
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        给定一颗二叉树和一个整数 sum，求累加和为 sum 的最长路径长度。
//        路径是指从某个节点往下，每次最多选择一个孩子节点或者不选所形成的节点链。
        int n = nextInt();
        int root = nextInt();
        treeNode node = read();
        int k = nextInt();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,-1);
        int len = getMaxLength(node,k, 0, 0, 0, map);
        System.out.println(len);
    }
}
