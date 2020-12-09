package JZ;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/9 9:03 上午
 */

public class CQueue {
    LinkedList<Integer> A, B;

    public CQueue() {
        A = new LinkedList();
        B = new LinkedList();
    }

    public void appendTail(int value) {
        A.addFirst(value);

    }

    public int deleteHead() {
        if (!B.isEmpty()) return B.removeLast();
        if (A.isEmpty()) return -1;
        while (!A.isEmpty()) {
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}
