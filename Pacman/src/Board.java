import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.ImageIcon;


public class Board extends JFrame implements Serializable{
    JTable jTable;
    private JLabel Timer;
    private int colIndex;
    private int rowIndex;
    ImageIcon imageIcon;
    ImageIcon wall;
    ImageIcon point;
    ImageIcon pacman2;
    ImageIcon dot;
    ImageIcon ghost;
    ImageIcon pacmanUp;
    ImageIcon pacmanDown;
    ImageIcon pacmanLeft;
    private final int[] punkty = {0};
    private final int[] zycia = {3};

    public void Gra(int number){
        switch(number){
            case 1 -> {
                this.colIndex = 10;
                this.rowIndex = 13;
            }
            case 2 -> {
                this.colIndex = 4;
                this.rowIndex = 13;
            }
            case 3, 4 -> {
                this.colIndex = 6;
                this.rowIndex = 8;
            }
            case 5 -> {
                this.colIndex = 11;
                this.rowIndex = 8;
            }
        }

        Font PressStart2P;

        imageIcon = new ImageIcon("pac1.png");
        wall = new ImageIcon("wall.jpg");
        point = new ImageIcon("yellowDot.png");
        dot = new ImageIcon("dot.png");
        ghost = new ImageIcon("ghost.png");
        pacman2 = new ImageIcon("pac2.png");
        pacmanUp = new ImageIcon("pacUp.png");
        pacmanLeft = new ImageIcon("pacLeft.png");
        pacmanDown = new ImageIcon("pacDown.png");


        String[] columns = switch(number){
            case 2, 4, 3 -> {
                String[] columns2 = {"Column 1", "Column 2", "Column 3", "Column 4", "Column 5", "Column 6", "Column 7",
                        "Column 8", "Column 9"};
                yield columns2;
            }
            default -> {
                String[] columns2 = {"Column 1", "Column 2", "Column 3", "Column 4", "Column 5", "Column 6", "Column 7", "Column 8",
                        "Column 9", "Column 10", "Column 11", "Column 12", "Column 13", "Column 14", "Column 15",
                        "Column 16", "Column 17", "Column 18", "Column 19", "Column 20", "Column 21"};
                yield columns2;
            }

        };
        Object[][] data = switch(number){
            case 1 -> {
                Object[][] board2 = {
                        {
                                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
                        },
                        {
                                1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1
                        },
                        {
                                1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1
                        },
                        {
                                1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1
                        },
                        {
                                1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 1, 2, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1
                        },
                        {
                                1, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 1
                        },
                        {
                                1, 1, 2, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1
                        },
                        {
                                1, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 2, 1, 2, 1, 2, 1, 2, 1, 4, 2, 4, 1, 2, 1, 2, 1, 1, 2, 1, 1
                        },
                        {
                                1, 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 2, 2, 2, 1, 2, 1, 2, 2, 2, 1
                        },
                        {
                                1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 2, 1, 1
                        },
                        {
                                1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1
                        },
                        {
                                1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1
                        },
                        {
                                1, 1, 2, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2, 2, 1, 1
                        },
                        {
                                1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1
                        },
                        {
                                1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
                        },
                } ;
                yield board2;
            }

            case 2 -> {
                Object[][] data2 = {
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 2, 2, 2, 1, 2, 2, 2, 1},
                        {1, 2, 1, 2, 1, 2, 1, 2, 1},
                        {1, 2, 1, 2, 1, 2, 1, 2, 1},
                        {1, 2, 2, 2, 2, 2, 2, 2, 1},
                        {1, 2, 1, 1, 1, 1, 1, 2, 1},
                        {1, 2, 2, 2, 1, 2, 2, 2, 1},
                        {1, 2, 1, 2, 1, 2, 1, 2, 1},
                        {1, 2, 2, 2, 2, 2, 2, 2, 1},
                        {1, 2, 1, 1, 2, 1, 1, 2, 1},
                        {1, 2, 2, 4, 4, 4, 2, 2, 1},
                        {1, 2, 1, 4, 2, 4, 1, 2, 1},
                        {1, 2, 1, 1, 1, 1, 1, 2, 1},
                        {1, 2, 2, 2, 3, 2, 2, 2, 1},
                        {1, 2, 1, 1, 1, 1, 1, 2, 1},
                        {1, 2, 2, 2, 1, 2, 2, 2, 1},
                        {1, 2, 1, 2, 1, 2, 1, 2, 1},
                        {1, 2, 2, 2, 1, 2, 2, 2, 1},
                        {1, 2, 1, 1, 1, 1, 1, 2, 1},
                        {1, 2, 2, 2, 1, 2, 2, 2, 1},
                        {1, 2, 1, 2, 1, 2, 1, 2, 1},
                        {1, 2, 2, 2, 2, 2, 2, 2, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},
                };
                yield data2;
            }
            case 3 -> {
                Object[][] data2 = {
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 2, 2, 2, 1, 2, 2, 2, 1},
                        {1, 2, 1, 2, 1, 2, 1, 2, 1},
                        {1, 2, 1, 2, 1, 2, 1, 2, 1},
                        {1, 2, 2, 2, 2, 2, 2, 2, 1},
                        {1, 2, 1, 1, 1, 1, 1, 2, 1},
                        {1, 2, 2, 2, 1, 2, 2, 2, 1},
                        {1, 2, 1, 2, 1, 2, 1, 2, 1},
                        {1, 2, 2, 2, 2, 2, 3, 2, 1},
                        {1, 2, 1, 1, 2, 1, 1, 2, 1},
                        {1, 2, 2, 4, 4, 4, 2, 2, 1},
                        {1, 2, 1, 4, 2, 4, 1, 2, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},
                };
                yield data2;
            }
            case 4 -> {
                Object[][] data2 = {
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 2, 2, 2, 1, 2, 2, 4, 1},
                        {1, 4, 1, 2, 1, 2, 1, 2, 1},
                        {1, 2, 1, 2, 1, 2, 1, 2, 1},
                        {1, 2, 2, 2, 2, 2, 2, 2, 1},
                        {1, 2, 1, 1, 1, 1, 1, 2, 1},
                        {1, 2, 2, 2, 1, 2, 2, 2, 1},
                        {1, 2, 1, 2, 1, 2, 1, 2, 1},
                        {1, 2, 2, 2, 2, 2, 3, 2, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},

                };
                yield data2;
            }
            case 5 ->  {
                Object[][] data2 = {
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                        {1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1},
                        {1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1},
                        {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                        {1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1},
                        {1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1},
                        {1, 2, 2, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1},
                        {1, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 3, 2, 2, 1, 2, 1, 2, 2, 2, 1},
                        {1, 2, 2, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1},
                        {1, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                        {1, 2, 1, 2, 2, 2, 2, 2, 2, 4, 1, 4, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},

                };
                yield data2;
            }
            default -> {
                Object[][] data2 = {{
                        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
                },
                        {
                                1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1
                        },
                        {
                                1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1
                        },
                        {
                                1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1
                        },
                        {
                                1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 1, 2, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1
                        },
                        {
                                1, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 1
                        },
                        {
                                1, 1, 2, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1
                        },
                        {
                                1, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 2, 1, 2, 1, 2, 1, 2, 1, 4, 2, 4, 1, 2, 1, 2, 1, 1, 2, 1, 1
                        },
                        {
                                1, 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 2, 2, 2, 1, 2, 1, 2, 2, 2, 1
                        },
                        {
                                1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 2, 1, 1
                        },
                        {
                                1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1
                        },
                        {
                                1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1
                        },
                        {
                                1, 1, 2, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2, 2, 1, 1
                        },
                        {
                                1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1
                        },
                        {
                                1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1
                        },
                        {
                                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
                        },
                } ;
                yield data2;
            }

        };
        jTable = new JTable();
        //zdaje sobie sprawe ze jest to plansza Defult po prostu po mimo starań nie udało mi sie dokonac tego samego na abstrakcie. Licze się z tym że może to spowodować wyzerowaniem punktów za projekt. Jednak mam nadzieję nawet jeśli jest złudna ze nie bedzie to bład kardynalny.
        jTable.setModel(new DefaultTableModel(data, columns) {
        });
        GhostMovement[] ghostMovements = switch(number){
            case 2, 3 -> {
                GhostMovement[] ghostMovements2 = {new GhostMovement(jTable, 3, 10),
                        new GhostMovement(jTable, 3, 11),  new GhostMovement(jTable, 5, 11),
                        new GhostMovement(jTable, 5,10), new GhostMovement(jTable, 4, 10)};
                yield ghostMovements2;
            }
            case 4 -> {
                GhostMovement[] ghostMovements2 = {new GhostMovement(jTable, 7, 1),
                        new GhostMovement(jTable, 1, 2)};
                yield ghostMovements2;
            }
            default -> {
                GhostMovement[] ghostMovements2 = {new GhostMovement(jTable, 10, 10),
                        new GhostMovement(jTable, 9, 11),  new GhostMovement(jTable, 11, 11),
                        new GhostMovement(jTable, 11, 10), new GhostMovement(jTable, 9, 10)};
                yield ghostMovements2;
            }
        };


        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setHorizontalAlignment(JLabel.CENTER);

                switch ((int) value) {
                    case 1:
                        label.setIcon(wall);
                        label.setBackground(Color.BLACK);
                        label.setForeground(Color.BLACK);
                        break;
                    case 2:
                        label.setIcon(point);
                        label.setBackground(Color.BLACK);
                        label.setForeground(Color.BLACK);
                        break;
                    case 3:
                        label.setIcon(imageIcon);
                        label.setBackground(Color.BLACK);
                        label.setForeground(Color.BLACK);
                        break;
                    case 4:
                        label.setIcon(ghost);
                        label.setBackground(Color.BLACK);
                        label.setForeground(Color.BLACK);
                        break;
                    case 5:
                        label.setIcon(pacmanUp);
                        label.setBackground(Color.BLACK);
                        label.setForeground(Color.BLACK);
                        break;
                    case 6:
                        label.setIcon(pacmanDown);
                        label.setBackground(Color.BLACK);
                        label.setForeground(Color.BLACK);
                        break;
                    case 7:
                        label.setIcon(pacmanLeft);
                        label.setBackground(Color.BLACK);
                        label.setForeground(Color.BLACK);
                        break;
                    case 8:

                        break;
                    default:
                        label.setIcon(dot);
                        label.setBackground(Color.BLACK);
                        label.setForeground(Color.BLACK);
                        break;
                }

                setText(value.toString());
                return label;
            }
        };


        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        JPanel panel = new JPanel();


        panel.add(new JScrollPane(jTable));


        JLabel punktyLabel = new JLabel("Punkty " + punkty[0]);
        punktyLabel.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        punktyLabel.setForeground(Color.PINK);

        JLabel zycialabel = new JLabel("  Zycia " + zycia[0] + "  ");

        zycialabel.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        zycialabel.setForeground(Color.PINK);

        Timer = new JLabel("Czas ");
        Timer.setFont(new Font("Press Start 2P", Font.PLAIN, 20));
        Timer.setForeground(Color.PINK);


        jTable.setDefaultRenderer(Object.class, renderer);
        final int[] size = {35};
        jTable.setRowHeight(size[0]);
        for (int i = 0; i < jTable.getColumnCount(); i++) {
            jTable.getColumnModel().getColumn(i).setPreferredWidth(size[0]);
        }
        for(GhostMovement g : ghostMovements)
            g.start();



        //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    Object value1 = jTable.getValueAt(rowIndex, colIndex);
                    Object value2 = jTable.getValueAt(rowIndex, colIndex + 1);
                    if (!value2.equals(1)) {
                        if (value2.equals(2)) {
                            value2 = 0;
                            punkty[0]++;
                            punktyLabel.setText("Punkty " + punkty[0]);
                            if (punkty[0]  >= 242) {
                                dispose();


                                String input = JOptionPane.showInputDialog(null, "Wprowadź NICK:");


                                HighScoreList.saveHighScore(input , punkty[0]);


                            }

                        }
                        if (value2.equals(5) || value2.equals(4) || value2.equals(6) || value2.equals(7)) {
                            zycia[0]--;
                            zycialabel.setText("  Zycia " + zycia[0]);
                            if (zycia[0] == 0) {
                                dispose();

                                String input = JOptionPane.showInputDialog(null, "Wprowadź NICK:");


                                HighScoreList.saveHighScore(input , punkty[0]);

                            }
                        }
                        jTable.setValueAt(value2, rowIndex, colIndex);
                        jTable.setValueAt(value1 = 3, rowIndex, colIndex + 1);

                        jTable.repaint();

                        colIndex++;

                    }
                    return true;

                }
                return false;
            }


        });


        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_LEFT) {

                    Object value1 = jTable.getValueAt(rowIndex, colIndex);
                    Object value2 = jTable.getValueAt(rowIndex, colIndex - 1);
                    if (!value2.equals(1)) {
                        if (value2.equals(2)) {
                            value2 = 0;
                            punkty[0]++;
                            punktyLabel.setText("Punkty " + punkty[0]);
                            if (punkty[0]  >= 242) {
                                dispose();

                                String input = JOptionPane.showInputDialog(null, "Wprowadź NICK:");

                                HighScoreList.saveHighScore(input , punkty[0]);

                            }
                        }
                        if (value2.equals(5) || value2.equals(4) || value2.equals(6) || value2.equals(7)) {
                            zycia[0]--;
                            zycialabel.setText("  Zycia " + zycia[0]);
                            if (zycia[0] == 0) {
                                dispose();

                                String input = JOptionPane.showInputDialog(null, "Wprowadź NICK:");


                                HighScoreList.saveHighScore(input , punkty[0]);

                            }
                        }
                        jTable.setValueAt(value2, rowIndex, colIndex);

                        jTable.setValueAt(value1 = 7, rowIndex, colIndex - 1);

                        jTable.repaint();
                        colIndex--;

                    }

                    return true;
                }
                return false;
            }
        });

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_UP) {

                    Object value1 = jTable.getValueAt(rowIndex, colIndex);
                    Object value2 = jTable.getValueAt(rowIndex - 1, colIndex);
                    if (!value2.equals(1)) {
                        if (value2.equals(2)) {
                            value2 = 0;
                            punkty[0]++;
                            punktyLabel.setText("Punkty " + punkty[0]);
                            if (punkty[0] >= 242) {
                                dispose();
                                String input = JOptionPane.showInputDialog(null, "Wprowadź NICK:");

                                HighScoreList.saveHighScore(input , punkty[0]);

                            }
                        }
                        if (value2.equals(5) || value2.equals(4) || value2.equals(6) || value2.equals(7)) {
                            zycia[0]--;
                            zycialabel.setText("  Zycia " + zycia[0]);
                            if (zycia[0] == 0) {
                                dispose();

                                String input = JOptionPane.showInputDialog(null, "Wprowadź NICK:");

                                HighScoreList.saveHighScore(input , punkty[0]);

                            }
                        }
                        jTable.setValueAt(value2, rowIndex, colIndex);
                        jTable.setValueAt(value1 = 5, rowIndex - 1, colIndex);

                        jTable.repaint();

                        rowIndex--;
                    }

                    return true;
                }
                return false;
            }
        });

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_DOWN) {
                    Object value1 = jTable.getValueAt(rowIndex, colIndex);
                    Object value2 = jTable.getValueAt(rowIndex + 1, colIndex);

                    if (!value2.equals(1)) {
                        if (value2.equals(2)) {
                            value2 = 0;
                            punkty[0]++;
                            punktyLabel.setText("Punkty " + punkty[0]);
                            if (punkty[0] >= 242) {
                                dispose();

                                String input = JOptionPane.showInputDialog(null, "Wprowadź NICK:");

                                HighScoreList.saveHighScore(input , punkty[0]);

                            }
                        }
                        if (value2.equals(5) || value2.equals(4) || value2.equals(6) || value2.equals(7)) {
                            zycia[0]--;
                            zycialabel.setText("  Zycia " + zycia[0]);
                            if (zycia[0] == 0) {
                                dispose();

                                String input = JOptionPane.showInputDialog(null, "Wprowadź NICK:");


                                HighScoreList.saveHighScore(input , punkty[0]);

                            }
                        }
                        jTable.setValueAt(value2, rowIndex, colIndex);
                        jTable.setValueAt(value1 = 6, rowIndex + 1, colIndex);

                        jTable.repaint();

                        rowIndex++;
                    }
                    return true;
                }
                return false;
            }
        });


        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_Q) {
                    dispose();
                    new Frame();
                    return true;
                }
                return false;
            }
        });




        JPanel statistics = new JPanel();
        statistics.setLayout(new FlowLayout());
        statistics.add(punktyLabel);
        statistics.add(zycialabel);
        statistics.add(Timer);


        statistics.setBackground(Color.BLACK);

        add(statistics, BorderLayout.NORTH);
        panel.setBackground(Color.BLACK);
        add(panel, BorderLayout.SOUTH);

        jTable.getTableHeader().setPreferredSize(new Dimension(0, 0));
        jTable.setEnabled(false);
        jTable.setDefaultRenderer(Object.class, renderer);
        jTable.setForeground(Color.black);
        jTable.setIntercellSpacing(new Dimension());


        setUndecorated(true);
        JScrollPane scrollPane = new JScrollPane(jTable);
        add(scrollPane);
        setSize(900, 894);
        setLocationRelativeTo(null);
        setVisible(true);

        startTimer();

    }
    private void startTimer() {
        Thread licznikThread = new Thread(() -> {
            int czas = 60;
            while (czas >= 0) {
                Timer.setText("Czas " + Integer.toString(czas));
                czas--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(czas ==0){
                    dispose();

                    String input = JOptionPane.showInputDialog(null, "Wprowadź NICK:");
                    HighScoreList.saveHighScore(input , punkty[0]);

                }
            }
        });

        licznikThread.start();
    }





}