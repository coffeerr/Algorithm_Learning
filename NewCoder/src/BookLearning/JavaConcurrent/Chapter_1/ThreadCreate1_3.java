package BookLearning.JavaConcurrent.Chapter_1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: wait方法和生产者-消费者模型
 * @author: Desmand
 * @time: 2020/11/2 11:44 上午
 */

public class ThreadCreate1_3 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int MAX_SIZE=10;
        synchronized (queue) {
            if(queue.size()==MAX_SIZE){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(1);
            queue.notifyAll();
        }
        synchronized (queue){
            if(queue.size()==0){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.poll();
            queue.notifyAll();
        }
    }
}
