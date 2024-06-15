import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class HighScoreFrame extends JFrame implements Serializable {

    private JList<Integer> list;
    private DefaultListModel<Integer> model;

    public HighScoreFrame() {
        model = new DefaultListModel<>();
        list = new JList<>(model);
    }

    public JList<Integer> getList() {
        return list;
    }

    public void addPointToList(int point) {
        model.addElement(point);
    }



    public void CreateHS(){
        JFrame oknoHighScore = new JFrame();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        Font PressStart2P;


        JLabel titleLabel = new JLabel("       High Score Ranking");
        titleLabel.setFont(new Font("Press Start 2P", Font.PLAIN , 25));
        titleLabel.setForeground(Color.WHITE);
        panel.setBackground(Color.BLACK);
        panel.add(titleLabel, BorderLayout.NORTH);


        JPanel panel1 = new JPanel();
        Container contentPane = getContentPane();
        GridBagConstraints gbc = new GridBagConstraints();

        HighScoreList.displayHighScores(panel1, panel, contentPane, gbc);

        JButton button = new JButton("Back");
        panel.add(button, BorderLayout.SOUTH );
        button.setBorderPainted(false);
        button.setFont(new Font("Press Start 2P", Font.PLAIN , 40));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(Color.YELLOW);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(Color.white);
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oknoHighScore.dispose();
            }
        });



        oknoHighScore.setSize(800, 800);
        oknoHighScore.setUndecorated(true);
        oknoHighScore.setBackground(Color.BLACK);
        oknoHighScore.setLocationRelativeTo(null);
        oknoHighScore.setContentPane(new JScrollPane(panel));
        oknoHighScore.setVisible(true);
        oknoHighScore.getContentPane().setBackground(Color.BLACK);
    }
}



