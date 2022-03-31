package ru.vsu.cs.aisd.g92.lyigina_p_s;

import java.util.PriorityQueue;

public class Solution {
    public static void stdQueueSolution(Task[] data) {
        int curTime = 0;
        PriorityQueue<Task> queue = new PriorityQueue<>();
        int i = 0;
        while (i < data.length) {
            while (i < data.length && data[i].getTime() <= curTime) {
                queue.add(data[i++]);
            }
            Task task = queue.remove();
            if (task.getTime() > curTime)
                curTime = task.getTime();
            task.setStart(curTime);
            curTime += task.getN();
            task.setEnd(curTime);
        }
    }

    public static void myQueueSolution(Task[] data) throws Exception {
        int curTime = 0;
        MyPriorityQueue<Task> queue = new MyPriorityQueue<>();
        int i = 0;
        while (i < data.length) {
            while (i < data.length && data[i].getTime() <= curTime) {
                queue.add(data[i++]);
            }
            Task task = queue.remove();
            if (task.getTime() > curTime)
                curTime = task.getTime();
            task.setStart(curTime);
            curTime += task.getN();
            task.setEnd(curTime);
        }
    }
}
