package ru.vsu.cs.aisd.g92.lyigina_p_s;

public class Task implements Comparable<Task>{
    private final int X;
    private final int N;
    private final int P;
    private final int time;
    private int start;
    private int end;

    public Task(int X, int N, int P, int t) {
        this.X = X;
        this.N = N;
        this.P = P;
        this.time = t;
    }

    @Override
    public int compareTo(Task o) {
        if (this.P == o.P) {
            if (this.time == o.time)
                return this.X - o.X;
            else
                return this.time - o.time;
        } else
            return o.P - this.P;
    }

    public int getN() {
        return N;
    }

    public int getTime() {
        return time;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int s) {
        start = s;
    }

    public void setEnd(int e) {
        end = e;
    }

    public static Task toTask(String str) {
        String[] s = str.split(" ");
        return new Task(Integer.parseInt(s[0]), Integer.parseInt(s[1]),
                Integer.parseInt(s[2]), Integer.parseInt(s[3]));
    }
}
