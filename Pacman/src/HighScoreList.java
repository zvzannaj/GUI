import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HighScoreList extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<HighScoreList> highScores = new ArrayList<>();
    private String nick;
    private int score;

    public HighScoreList(String nick, int score) {
        this.nick = nick;
        this.score = score;
    }

    public static void saveHighScore(String nick, int score) {
        HighScoreList highScore = new HighScoreList(nick, score);
        highScores.add(highScore);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("highscores.txt"))) {
            objectOutputStream.writeObject(highScores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayHighScores(JPanel panel1, JPanel panel, Container contentPane, GridBagConstraints gbc) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("highscores.txt"))) {
            highScores = (List<HighScoreList>) objectInputStream.readObject();

            panel1.setLayout(new GridLayout(highScores.size(), 1, 10, 10));

            for (int i = 0; i < highScores.size(); i++) {
                JLabel label = new JLabel(highScores.get(i).getNick() + " - " + highScores.get(i).getScore());
                label.setFont(new Font("Press Start 2P", Font.PLAIN, 15));
                label.setForeground(Color.WHITE);
                panel1.add(label);
            }

            gbc.gridx = 0;
            gbc.gridy = 0;
            contentPane.add(panel1, gbc);

            panel.add(panel1, BorderLayout.CENTER);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
