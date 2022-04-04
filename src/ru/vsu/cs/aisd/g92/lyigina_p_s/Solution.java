package ru.vsu.cs.aisd.g92.lyigina_p_s;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void stdQueueSolution(Task[] data) {
        if (data.length == 0) {
            return;
        }
        PriorityQueue<Task> queue1 = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getTime() - o2.getTime();
            }
        });
        queue1.addAll(Arrays.asList(data));

        PriorityQueue<Task> queue2 = new PriorityQueue<>();
        Task task1 = queue1.remove();
        queue2.add(task1);
        int curTime = task1.getTime();
        //int i = 0;
        while (!queue2.isEmpty()) {
            while (!queue1.isEmpty() && queue1.element().getTime() <= curTime) {
                queue2.add(queue1.remove());
            }
            Task task = queue2.remove();
            if (task.getTime() > curTime)
                curTime = task.getTime();
            task.setStart(curTime);
            curTime += task.getN();
            task.setEnd(curTime);

            if (queue2.isEmpty() && !queue1.isEmpty()) {
                task1 = queue1.remove();
                queue2.add(task1);
                curTime = task1.getTime();
            }
        }
    }

    public static void myQueueSolution(Task[] data) throws Exception {
        if (data.length == 0) {
            return;
        }
        MyPriorityQueue<Task> queue1 = new MyPriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getTime() - o2.getTime();
            }
        });
        for (Task task : data) {
            queue1.add(task);
        }

        PriorityQueue<Task> queue2 = new PriorityQueue<>();
        Task task1 = queue1.remove();
        queue2.add(task1);
        int curTime = task1.getTime();
        //int i = 0;
        while (!queue2.isEmpty()) {
            while (!queue1.isEmpty() && queue1.element().getTime() <= curTime) {
                queue2.add(queue1.remove());
            }
            Task task = queue2.remove();
            if (task.getTime() > curTime)
                curTime = task.getTime();
            task.setStart(curTime);
            curTime += task.getN();
            task.setEnd(curTime);

            if (queue2.isEmpty() && !queue1.isEmpty()) {
                task1 = queue1.remove();
                queue2.add(task1);
                curTime = task1.getTime();
            }
        }
    }
}
