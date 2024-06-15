import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomFrame extends JFrame {
    public CustomFrame() {
        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        JLabel label = new JLabel("Enter the number of Columns");
        label.setFont(new Font("Press Start 2P", Font.PLAIN , 25));
        label.setForeground(Color.white);

        JLabel label1 = new JLabel("Enter the number of rows\n");
        label1.setFont(new Font("Press Start 2P", Font.PLAIN , 25));
        label1.setForeground(Color.white);


        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        JLabel imagine = new JLabel();
        imagine.setIcon(new ImageIcon("PacMan.png"));

        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        JTextField textField = new JTextField();
        textField.setFont(new Font("Press Start 2P", Font.PLAIN , 25));
        textField.setForeground(Color.PINK);
        textField.setBackground(Color.BLACK);


        JTextField textField1 = new JTextField();
        textField1.setFont(new Font("Press Start 2P", Font.PLAIN , 25));
        textField1.setForeground(Color.PINK);
        textField1.setBackground(Color.BLACK);

        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=


        JButton backButton = new JButton("Back");
        backButton.setBorderPainted(false);
        backButton.setFont(new Font("Press Start 2P", Font.PLAIN , 30));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.white);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setForeground(Color.YELLOW);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setForeground(Color.white);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        JButton SubmitButton = new JButton("Submit");
        SubmitButton.setBorderPainted(false);
        SubmitButton.setFont(new Font("Press Start 2P", Font.PLAIN , 30));
        SubmitButton.setBackground(Color.BLACK);
        SubmitButton.setForeground(Color.white);
        SubmitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                SubmitButton.setForeground(Color.PINK);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                SubmitButton.setForeground(Color.white);
            }
        });
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int kolumny = Integer.parseInt(textField.getText());
                    int wiersze = Integer.parseInt(textField1.getText());
                    if(kolumny<=100 && wiersze<=100){
                        JTable jTable = new JTable();
                        jTable.setModel(new DefaultTableModel(wiersze, kolumny));

                        jTable.setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(CustomFrame.this,
                                "you passed the limit (100)",
                                "Błąd",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CustomFrame.this,
                            "Nieprawidłowa liczba!",
                            "Błąd",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(SubmitButton);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(Color.BLACK);

        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        imagine.setLayout(new FlowLayout());
        add(imagine);
        JPanel frame = new JPanel();
        frame.setLayout(new GridLayout(5,1,10,10));
        frame.add(label);
        frame.add(textField);
        frame.add(label1);
        frame.add(textField1);
        frame.add(buttonPanel);
        frame.setBackground(Color.BLACK);

        frame.setOpaque(false);


        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        getContentPane().add(frame, gbc);

        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        setUndecorated(true);
        setSize(800,800);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



    }





}
