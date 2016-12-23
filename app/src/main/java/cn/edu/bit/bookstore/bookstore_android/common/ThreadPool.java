package cn.edu.bit.bookstore.bookstore_android.common;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Haochengqian on 16/12/16.
 */
public class ThreadPool {
    public static ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(6);
    public static void clearExecut(){
        executor.getQueue().clear();
    }
}
