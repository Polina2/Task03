package ru.vsu.cs.aisd.g92.lyigina_p_s;

import ru.vsu.cs.util.JTableUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
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
    private DefaultTableModel tableModel;
    private String[] headers1 = new String[]{"X", "N", "P", "Time"};
    private String[] headers2 = new String[]{"X", "Start", "End"};

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

        JTableUtils.initJTableForArray(tableInput, 100, true, true, true, true, headers1);
        JTableUtils.initJTableForArray(tableOutput, 70, true, true, false, false, headers2);
/*
        DefaultTableModel tableModel1 = new DefaultTableModel(new String[] { "[0]" }, 1) {
            @Override
            public String getColumnName(int index) {
                return headers[index];
            }
        };

 */
       // tableModel = new DefaultTableModel();
        //tableModel.setColumnIdentifiers(headers);
        //tableInput.setModel(tableModel);
/*
        tableInput.setColumnModel(new DefaultTableColumnModel(){
            @Override
            public int getColumnCount() {
                return 4;
            }

        });

 */
/*
        class TableWithColumns extends AbstractTableModel {
            private String[] names;

            public TableWithColumns(String[] names) {
                this.names = names;
            }

            @Override
            public int getRowCount() {
                return 0;
            }

            @Override
            public int getColumnCount() {
                return names.length;
            }

            @Override
            public String getColumnName(int column) {
                return names[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return null;
            }
        }

        tableInput.setModel(new TableWithColumns(new String[]{"aaa", "bbb", "ccc", "ddd"}));
*/

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
