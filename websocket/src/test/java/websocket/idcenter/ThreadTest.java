 
package websocket.idcenter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadTest {
    private static int thread_num = 500;
    private static int client_num = 1000;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Set<Long> idSet = Collections.synchronizedSet(new HashSet<>());  
        final Semaphore semp = new Semaphore(thread_num);

        for (int index = 0; index < client_num; index++) {

            final int NO = index;

            Runnable run = new Runnable() {
                public void run() {
                    try {
                        semp.acquire();
                        long val =   SidWorker.nextSid();  
    	                if (idSet.contains(val)){  
    	                    System.out.println("重复了: " + val);  
    	                }else{  
    	                    idSet.add(val);  
    	                } 
                        semp.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        exec.shutdown();
    }
    
}