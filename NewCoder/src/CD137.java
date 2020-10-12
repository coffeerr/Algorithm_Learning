import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

//给定一个无序链表，删除其中值重复出现的节点(保留当中顺序遍历第一个出现的节点)。
public class CD137 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Node read(int n) {
        Node head = new Node(0);
        Node dummyNode = head;
        for(int i = 0;i<n;i++){
            dummyNode.next = new Node(nextInt());
            dummyNode = dummyNode.next;
        }
        return head.next;
    }
    public static void deleteRepeatableNode(Node head){
        //首先是要遍历，并把数值存入HashMap中
        //遍历过程中，如果hashMap中已经存在这个key，就删除该节点。
        Node node = head;
        Node pre = null;
        Node next = null;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(node!=null){
            next = node.next;
            if(map.containsKey(node.val)){
                pre.next = next;
                node = next;
                if(node == null)break;
                continue;
            }
            map.put(node.val,1);
            pre = node;
            node = node.next;
        }
    }
    public static void main(String[] args) {
        int n = nextInt();
        Node head = read(n);
        deleteRepeatableNode(head);
        while(head!=null){
            System.out.print(head.val+" ");
            head= head.next;
        }
    }
}
