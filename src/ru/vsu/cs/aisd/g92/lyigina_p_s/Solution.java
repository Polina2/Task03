package ru.vsu.cs.aisd.g92.lyigina_p_s;

import java.util.PriorityQueue;

public class Solution {
    public static void stdQueueSolution(Task[] data) {
        PriorityQueue<Task> queue = new PriorityQueue<>();
        queue.add(data[0]);
        int curTime = data[0].getTime();
        int i = 0;
        while (!queue.isEmpty()) {
            while (i+1 < data.length && data[i+1].getTime() <= curTime) {
                queue.add(data[++i]);
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
        MyPriorityQueue<Task> queue = new MyPriorityQueue<>();
        queue.add(data[0]);
        int curTime = data[0].getTime();
        int i = 0;
        while (!queue.isEmpty()) {
            while (i+1 < data.length && data[i+1].getTime() <= curTime) {
                queue.add(data[++i]);
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
