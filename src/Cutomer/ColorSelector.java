package Cutomer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorSelector extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> colorComboBox;
    private JLabel colorLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ColorSelector frame = new ColorSelector();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ColorSelector() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setTitle("Color Selector");
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        colorComboBox = new JComboBox<>();
        colorComboBox.setBounds(100, 30, 100, 30);
        colorComboBox.addItem("Red");
        colorComboBox.addItem("Green");
        colorComboBox.addItem("Blue");
        contentPane.add(colorComboBox);

        colorLabel = new JLabel("Selected color will appear here");
        colorLabel.setBounds(50, 100, 200, 30);
        contentPane.add(colorLabel);

        colorComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                switch (selectedColor) {
                    case "Red":
                        colorLabel.setText("Selected color: Red");
                        colorLabel.setForeground(java.awt.Color.RED);
                        break;
                    case "Green":
                        colorLabel.setText("Selected color: Green");
                        colorLabel.setForeground(java.awt.Color.GREEN);
                        break;
                    case "Blue":
                        colorLabel.setText("Selected color: Blue");
                        colorLabel.setForeground(java.awt.Color.BLUE);
                        break;
                    default:
                        colorLabel.setText("Selected color will appear here");
                        colorLabel.setForeground(java.awt.Color.BLACK);
                        break;
                }
            }
        });
    }
}
