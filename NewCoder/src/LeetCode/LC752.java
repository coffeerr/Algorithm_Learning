package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/14 9:49 上午
 */

public class LC752 {
    String up(String s, int j) {
        char[] c = s.toCharArray();
        if (c[j] == '9') {
            c[j] = '0';
        } else {
            c[j] += 1;
        }
        return new String(c);
    }

    String down(String s, int j) {
        char c[] = s.toCharArray();
        if (c[j] == '0') {
            c[j] = '9';
        } else {
            c[j] -= 1;
        }
        return new String(c);
    }

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> dead = new HashSet<>();
        for (String s : deadends) dead.add(s);
        int step = 0;
        queue.offer("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curS = queue.poll();
                if(dead.contains(curS))continue;
                if (curS.equals(target)) return step;
                for (int j = 0; j < 4; j++) {
                    String upS = up(curS, j);
                    String downS = down(curS, j);
//                    if (upS.equals(target) || downS.equals(target)) {
//                        return step + 1;
//                    }
                    if (!visited.contains(upS)) {
                        visited.add(upS);
                        queue.offer(upS);
                    }
                    if (!visited.contains(downS)) {
                        visited.add(downS);
                        queue.offer(downS);
                    }
                }
            }
            step++;
        }
        return -1;
    }

}
