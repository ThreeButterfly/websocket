package websocket.idcenter;


/**
 * @author adyliu (imxylz@gmail.com)
 * @since 2016-06-28
 */
public class SidWorkerDemo {
	
	   public void  test3(){  
	        //测试单机性能  
	        System.out.println("--------测试单线程性能------------------");  
	      
	        long t1 = System.currentTimeMillis();  
	        int total = 10000000;  
	        for (int i=0; i<total; i++){  
	        	  SidWorker.nextSid(); 
	        }  
	        System.out.println("单线程生成" + total + "个ID共耗时: " + (System.currentTimeMillis() - t1) + "ms");  
	    }
    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        final int max = 100000;
        for (int i = 0; i < max; i++) {
            SidWorker.nextSid();
           
        }
        long et = System.currentTimeMillis();
        System.out.println(1000 * max / (et - st) + "/s");
        
    }
}
