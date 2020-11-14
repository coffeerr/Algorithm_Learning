package Interview.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/13 10:31 上午
 */

public class SemaphoreTest {
    private static volatile Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println(Thread.currentThread()+" A task over");
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println(Thread.currentThread()+" A task over");
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        semaphore.acquire(2);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println(Thread.currentThread()+" B task over");
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println(Thread.currentThread()+" B task over");
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        semaphore.acquire(2);
        System.out.println("Task is over!");
        executorService.shutdown();
    }
}
