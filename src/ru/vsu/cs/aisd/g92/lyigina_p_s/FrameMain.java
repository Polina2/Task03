package ru.vsu.cs.aisd.g92.lyigina_p_s;

import javax.swing.*;

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
    }
}
