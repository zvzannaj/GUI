import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Frame extends JFrame {

    public Frame(){
        Font PressStart2P;
        ImageIcon image;

        try{
            PressStart2P = Font.createFont(Font.TRUETYPE_FONT , new File("PressStart2P-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PressStart2P-Regular.ttf")));

        }catch (IOException | FontFormatException e){

        }

        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        JButton b1 = new JButton("New Game");
        b1.setBorderPainted(false);
        b1.setBackground(Color.BLACK);
        b1.setFont(new Font("Press Start 2P", Font.PLAIN , 40));
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

        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        JButton b2 = new JButton("High Score");
        b2.setBorderPainted(false);
        b2.setFont(new Font("Press Start 2P", Font.PLAIN , 40));
        b2.setBackground(Color.BLACK);
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

        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        JButton b3 = new JButton("Exit");
        b3.setBorderPainted(false);
        b3.setFont(new Font("Press Start 2P", Font.PLAIN , 40));
        b3.setBackground(Color.BLACK);
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

        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

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

        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        getContentPane().add(buttonPanel, gbc);

        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        b1.addActionListener(new ActionListener() {
            //changed
            @Override
            public void actionPerformed(ActionEvent e) {
                new Mode();
            }
        });

        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HighScoreFrame oknoHighScore = new HighScoreFrame();
                oknoHighScore.CreateHS();


            }
        });

        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setUndecorated(true);
        setSize(800,800);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


}
