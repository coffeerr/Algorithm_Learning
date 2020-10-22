package Desk;

import Algorithm.CD161;
import Algorithm.CD164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/10/21 2:40 下午
 */

public class Morris {
    public static class treeNode {
        public int val;
        public treeNode right;
        public treeNode left;

        public treeNode(int val) {

            this.val = val;
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
        int fa, lch, rch;
        fa = nextInt();
        lch = nextInt();
        rch = nextInt();
        treeNode node = new treeNode(fa);
        if (lch != 0) {
            node.left = read();
        }
        if (rch != 0) {
            node.right = read();
        }
        return node;
    }

    public static void normalMorris(treeNode node) {
        if (node == null) return;
        treeNode cur = node;
        treeNode mosRight = null;
        while (cur != null) {
            System.out.print(cur.val+" ");
            mosRight = cur.left;
            if (mosRight != null) {

                while (mosRight.right != null && mosRight.right != cur) {
                    mosRight = mosRight.right;
                }
                //mosRight此时为cur左子树的最右边子节点
                if (mosRight.right == null) {
                    //如果mosRight的右节点为空，则让其指向cur
                    //此时为第一次抵达最右节点
                    mosRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    //如果不为空，其实就是指向了cur已经，则令其为空
                    //此时为第二次抵达最右节点
                    mosRight.right = null;
                }
            }
            //左节点结束，回到右节点
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        int n = nextInt();
        int root = nextInt();
        treeNode node = read();
        normalMorris(node);
    }
}
