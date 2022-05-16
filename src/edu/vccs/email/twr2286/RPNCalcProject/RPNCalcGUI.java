package edu.vccs.email.twr2286.RPNCalcProject;

import javax.swing.*;
import java.awt.*;

/**
 * Where the calculator GUI is made
 * 2022-04-08
 * @author Tim Root
 */
public class RPNCalcGUI extends JFrame {
    private RPNCalcGUIHelper helper = new RPNCalcGUIHelper();  //for interpreting button presses

    private static final String[][] KEYLABELS = {              //key layout
            {"7", "8", "9", "π", "/"},
            {"4", "5", "6", "τ", "*"},
            {"1", "2", "3", "<", "-"},
            {"0", ".", "+/-", "^", "+"}
    };
    private JPanel panel = new JPanel(new BorderLayout(5,5));
    private JPanel keyPanel = new JPanel();
    private JTextField calcWindow = new JTextField();

    /**
     * Constructor for calculator GUI
     */
    public RPNCalcGUI() {
        setTitle("");
        setLayout(new GridBagLayout());

        int rows = KEYLABELS.length;
        int columns = KEYLABELS[0].length;
        keyPanel.setLayout(new GridLayout(rows, columns, 5, 5));
        for (String[] labelRow : KEYLABELS) {
            for (String label : labelRow) {
                if (label.trim().isEmpty()) {
                    keyPanel.add(new JLabel());
                } else {
                    JButton button = createButton(label);
                    button.addActionListener(e -> calcWindow.setText(helper.addKey(label)));
                    button.setActionCommand(label);
                    keyPanel.add(button);
                }
            }
        }

        calcWindow.setFont(calcWindow.getFont().deriveFont(30));
        calcWindow.setEditable(false);
        calcWindow.setFocusable(false);


        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.add(keyPanel, BorderLayout.CENTER);
        panel.add(this.calcWindow, BorderLayout.PAGE_START);


        JFrame frame = new JFrame("Reverse Polish Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * helps set up button formatting
     * @param btnLabel label on the button
     * @return resulting button
     */
    private JButton createButton (String btnLabel) {
        JButton button = new JButton(btnLabel);
        button.setFont(button.getFont().deriveFont(20));
        return button;
    }

    /**
     * main method that calls the calculator constructor
     * @param args not used
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new RPNCalcGUI());
    }

}

