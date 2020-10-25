package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/10/24 7:30 下午
 */

public class CD167 {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
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

    public static Node read() {
        int fa, lth, rth;
        fa = nextInt();
        lth = nextInt();
        rth = nextInt();
        if (fa == 0) return null;
        Node node = new Node(fa);
        if (lth != 0) {
            node.left = read();
        }
        if (rth != 0) {
            node.right = read();
        }
        return node;
    }
    public static Node process(Node head){
        if(head==null)return null;
        return null;
    }
}
