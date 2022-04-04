package ru.vsu.cs.aisd.g92.lyigina_p_s;

import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.JTableUtils;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;

public class Utils {
    public static Task[] fileToArray(String fileName) throws FileNotFoundException {
        String[] strs = ArrayUtils.readLinesFromFile(fileName);
        Task[] tasks = new Task[strs.length];
        for (int i = 0; i < strs.length; i++) {
            tasks[i] = Task.toTask(strs[i]);
        }
        return tasks;
    }

    public static void arrayToTable(Task[] arr, JTable table, boolean isInput) {
        String[][] strArr = new String[arr.length][(isInput)?4:3];
        /*
        strArr[0][0] = "X";
        if (isInput) {
            strArr[0][1] = "Number of pages";
            strArr[0][2] = "Priority";
            strArr[0][3] = "Time";
        } else {
            strArr[0][1] = "Start";
            strArr[0][2] = "End";
        }
        */
        for (int i = 0; i < arr.length; i++) {
            strArr[i][0] = "" + arr[i].getX();
            if (isInput) {
                strArr[i][1] = "" + arr[i].getN();
                strArr[i][2] = "" + arr[i].getP();
                strArr[i][3] = "" + arr[i].getTime();
            } else {
                strArr[i][1] = "" + arr[i].getStart();
                strArr[i][2] = "" + arr[i].getEnd();
            }
        }
        JTableUtils.writeArrayToJTable(table, strArr);
    }

    public static Task[] tableToArray(JTable table, boolean isInput) {
        String[][] strArray = JTableUtils.readStringMatrixFromJTable(table);
        Task[] arr = new Task[Objects.requireNonNull(strArray).length];
        for (int i = 0; i < arr.length; i++) {
            if (isInput) {
                arr[i] = new Task(Integer.parseInt(strArray[i][0]), Integer.parseInt(strArray[i][1]),
                        Integer.parseInt(strArray[i][2]), Integer.parseInt(strArray[i][3]));
            } else {
                arr[i] = new Task(Integer.parseInt(strArray[i][0]), Integer.parseInt(strArray[i][1]),
                        Integer.parseInt(strArray[i][2]));
            }
        }
        return arr;
    }

    public static void arrayToFile(Task[] arr, String fileName) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);
        for (Task task : arr) {
            out.println("" + task.getX() + " " + task.getStart() + " " + task.getEnd());
        }
    }
}
