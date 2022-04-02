package ru.vsu.cs.aisd.g92.lyigina_p_s;

import ru.vsu.cs.util.JTableUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public class FrameMain extends JFrame {

    private JPanel panelMain;
    private JScrollPane scrollPaneInput;
    private JScrollPane scrollPaneOutput;
    private JTable tableInput;
    private JTable tableOutput;
    private JButton buttonRead;
    private JButton buttonStdSolution;
    private JButton buttonMySolution;
    private JButton buttonSave;

    public FrameMain() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JFileChooser fileChooserOpen = new JFileChooser();
        JFileChooser fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);
        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        JTableUtils.initJTableForArray(tableInput, 90, true, false, true, false);
        JTableUtils.initJTableForArray(tableOutput, 70, true, false, false, false);

        buttonRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    try {
                        Task[] arr = Utils.fileToArray(fileChooserOpen.getSelectedFile().getPath());
                        Utils.arrayToTable(arr, tableInput, true);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        buttonStdSolution.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task[] arr = Utils.tableToArray(tableInput, true);
                Solution.stdQueueSolution(arr);
                Utils.arrayToTable(arr, tableOutput, false);
            }
        });
        buttonMySolution.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task[] arr = Utils.tableToArray(tableInput, true);
                try {
                    Solution.myQueueSolution(arr);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                Utils.arrayToTable(arr, tableOutput, false);
            }
        });
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooserSave.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    Task[] arr = Utils.tableToArray(tableOutput, false);
                    try {
                        Utils.arrayToFile(arr, fileChooserSave.getSelectedFile().getPath());
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}
