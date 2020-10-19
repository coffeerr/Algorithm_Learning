package AI.MCProblem;

import Algorithm.CD158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class test01 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static class Node {
        //修道士人数
        int m;
        //野人人数
        int c;
        //当前船的状态，1表示在左，0表示在右
        int b;

        int f;

        public Node(int m, int c, int b) {
            this.m = m;
            this.c = c;
            this.b = b;
        }
    }

    public static int getF(Node node, int depth) {
        /**
         * @Description: 获得评估值
         * @param [node, depth]
         * @return int
         * @author Desmand
         * @Date 2020/10/17
         */
        int h = node.m + node.c - 2 * node.b;
        int g = depth;
        int f = g + h;
        return f;
    }

    public static boolean isStateSafe(Node node) {
        int m = node.m;
        int c = node.c;
        int b = node.b;
        if (m > 0 && c > m) {
            return false;
        }
        return true;
    }

    public static boolean isStateLegal(Node node) {
        int m = node.m;
        int c = node.c;
        int b = node.b;
        if (m < 0 || c < 0) {
            return false;
        }
        return true;
    }

    public static ArrayList<Node> listWays(Node node) {
        int m = node.m;
        int c = node.c;
        int b = node.b;
        ArrayList<Node> list = new ArrayList<Node>();
        //m,c,b,1表示在左边触发，-1表示在右边出发
        int[][] lways = {{1, 0, 1}, {0, 1, 1}, {1, 1, 1}, {0, 2, 1}, {2, 0, 1}};
        int[][] rways = {{1, 0, -1}, {0, 1, -1}, {1, 1, -1}, {0, 2, -1}, {2, 0, -1}};
        int[][] ways;
        if (b == 0) {
            ways = rways;
        } else {
            ways = lways;
        }
        int arr[] = {0, 0, 0};
        for (int i = 0; i < 5; i++) {
            arr[0] = m - ways[i][0];
            arr[1] = c - ways[i][1];
            arr[2] = b - ways[i][2];
            Node curNode = new Node(arr[0], arr[1], arr[2]);
            if (isStateLegal(curNode) && isStateSafe(curNode)) {
                list.add(curNode);
            }
        }
        return list;
    }

    public static ArrayList<Node> AStar(Node startNode) {
        ArrayList<Node> openList = new ArrayList<>();
        ArrayList<Node> closedList = new ArrayList<>();
        if (!isStateSafe(startNode) || !isStateLegal(startNode)) {
            return null;
        }
        openList.add(startNode);
        Node curNode = startNode;
        int depth = 0;
        while (!openList.isEmpty()) {
            if (openList.contains(startNode)) {
                openList.remove(startNode);
            }
            depth++;
            int min = 1000000;
            openList = listWays(curNode);
            for (int i = 0; i < openList.size(); i++) {
                openList.get(i).f = getF(openList.get(i), depth);
                if (min >= openList.get(i).f) {
                    min = openList.get(i).f;
                }
            }
            Node next = null;
            //没有考虑到相同f值的情况
            for (Node n : openList) {
                if (n.f == min) {
                    next = n;
                }
            }
            closedList.add(next);
            curNode = next;
        }
        return closedList;

    }

    public static void main(String[] args) {
        System.out.println("请输入m、c的值：");
        int m = nextInt();
        int c = nextInt();
        Node node = new Node(m, c, 1);
        ArrayList<Node> head = AStar(node);
    }
}
