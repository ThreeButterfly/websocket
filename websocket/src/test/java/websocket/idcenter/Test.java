/******************************************************************
 *
 *    Package:     websocket.id
 *
 *    Filename:    Test.java
 *    Package:     websocket.id
 *
 *    Filename:    Test.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:   成都市润东实业有限公司 软件开发部
 *
 *    @author:     Tjee
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年8月9日 上午9:56:58
 *
 *    Revision:
 *
 *    2017年8月9日 上午9:56:58
 *        - first revision
 *
 *****************************************************************/
package websocket.idcenter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import websocket.idcenter.SidWorker;

/**
 * @ClassName Test
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Tjee
 * @Date 2017年8月9日 上午9:56:58
 * @version 1.0.0
 */
public class Test {
	 public void test2(){  
	        //多线程测试  
		 long t1 = System.currentTimeMillis();  
	        System.out.println("--------多线程测试不重复------------------");  
	        Set<Long> idSet = Collections.synchronizedSet(new HashSet<>());  
	        ExecutorService es = Executors.newFixedThreadPool(2); 
	        int total=1000;
	        for (int i=0; i<total; i++){  
	            es.submit(() -> {  
	                long val =   SidWorker.nextSid();  
	                if (idSet.contains(val)){  
	                    System.out.println("重复了: " + val);  
	                }else{  
	                    idSet.add(val);  
	                }  
	            });  
	        }  
	        es.shutdown();  
	        System.out.println("启用顺序关闭");  
	        while(true){    
	            if(es.isTerminated()){  
	                System.out.println("所有的子线程都结束了！");    
	                break;  
	            }  
	            try {  
	                System.out.println("子线程的任务还没运行完");  
	                Thread.sleep(1000);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	            }  
	        }    
	        System.out.println("共生成: " + idSet.size() + "个");  
	        System.out.println("单线程生成" + total + "个ID共耗时: " + (System.currentTimeMillis() - t1)/1000 + "s");  
	    }  
	 
	 public static void main(String[] args) {
		 new Test().test2();
	}
}
