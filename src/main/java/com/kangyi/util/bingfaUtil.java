package com.kangyi.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bingfaUtil {
    static List<String> tickets = new LinkedList<>();

    static {
        for (int i = 0; i < 10000; i++)
            tickets.add("票编号： " + i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    synchronized (tickets) {
                        if (tickets.size() == 0)
                            break;
                        System.out.println( finalI +"销售了票--" + tickets.remove(0));
                    }
                }
            }).start();
        }
    }



}
