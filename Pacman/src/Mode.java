import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mode extends JFrame{
    public Mode() {

        JButton b1 = new JButton("rozmiar: 21x23");
        b1.setBorderPainted(false);
        b1.setBackground(Color.BLACK);
        b1.setFont(new Font("Press Start 2P", Font.PLAIN , 20));
        b1.setForeground(Color.white);
        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b1.setForeground(Color.PINK);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                b1.setForeground(Color.white);
            }
        });
        JButton b2 = new JButton("rozmiar: 9x22");
        b2.setBorderPainted(false);
        b2.setBackground(Color.BLACK);
        b2.setFont(new Font("Press Start 2P", Font.PLAIN , 20));
        b2.setForeground(Color.white);
        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b2.setForeground(Color.PINK);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                b2.setForeground(Color.white);
            }
        });
        JButton b3 = new JButton("rozmiar: 9x13");
        b3.setBorderPainted(false);
        b3.setBackground(Color.BLACK);
        b3.setFont(new Font("Press Start 2P", Font.PLAIN , 20));
        b3.setForeground(Color.white);
        b3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b3.setForeground(Color.PINK);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                b3.setForeground(Color.white);
            }
        });
        JButton b4 = new JButton("rozmiar: 21x23");
        b4.setBorderPainted(false);
        b4.setBackground(Color.BLACK);
        b4.setFont(new Font("Press Start 2P", Font.PLAIN , 20));
        b4.setForeground(Color.white);
        b4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b4.setForeground(Color.PINK);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                b4.setForeground(Color.white);
            }
        });
        JButton b5 = new JButton("rozmiar: 21x23");
        b5.setBorderPainted(false);
        b5.setBackground(Color.BLACK);
        b5.setFont(new Font("Press Start 2P", Font.PLAIN , 20));
        b5.setForeground(Color.white);
        b5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b5.setForeground(Color.PINK);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                b5.setForeground(Color.white);
            }
        });

        JButton b6 = new JButton("Back");
        b6.setBorderPainted(false);
        b6.setFont(new Font("Press Start 2P", Font.PLAIN , 20));
        b6.setBackground(Color.WHITE);
        b6.setForeground(Color.white);
        b6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b6.setForeground(Color.PINK);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                b6.setForeground(Color.white);
            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board board = new Board();
                board.Gra(1);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board board = new Board();
                board.Gra(2);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board board = new Board();
                board.Gra(3);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board board = new Board();
                board.Gra(4);
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board board = new Board();
                board.Gra(5);
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });




        JPanel buttonPanel = new JPanel();
        JLabel imagine = new JLabel();
        imagine.setIcon(new ImageIcon("PacMan.png"));
        imagine.setLayout(new FlowLayout());
        add(imagine);
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);

        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        getContentPane().add(buttonPanel, gbc);



        setUndecorated(true);
        setSize(800,800);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}