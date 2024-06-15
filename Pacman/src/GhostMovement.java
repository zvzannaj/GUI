import javax.swing.*;
import java.util.Random;

public class GhostMovement extends Thread{
    private JTable table;
    private int rowIndex;
    private int colIndex;

    public GhostMovement(JTable table, int colIndex, int rowIndex){
        this.table = table;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true){
            int x = random.nextInt(4);
            if(x == 0) {
                Object value1 = table.getValueAt(rowIndex, colIndex);
                Object value2 = table.getValueAt(rowIndex, colIndex + 1);
                if (!value2.equals(1) && !value2.equals(4) && !value2.equals(3) && !value2.equals(5) && !value2.equals(6) && !value2.equals(7)) {

                    table.setValueAt(value2, rowIndex, colIndex);
                    table.setValueAt(value1, rowIndex, colIndex + 1);

                    table.repaint();

                    colIndex++;
                }
            }
            if(x==1) {
                Object value1 = table.getValueAt(rowIndex, colIndex);
                Object value2 = table.getValueAt(rowIndex, colIndex - 1);
                if (!value2.equals(1) && !value2.equals(4) && !value2.equals(3) && !value2.equals(5) && !value2.equals(6) && !value2.equals(7)) {

                    table.setValueAt(value2, rowIndex, colIndex);

                    table.setValueAt(value1, rowIndex, colIndex - 1);

                    table.repaint();
                    colIndex--;

                }
            }
            if(x==2) {
                Object value1 = table.getValueAt(rowIndex, colIndex);
                Object value2 = table.getValueAt(rowIndex - 1, colIndex);
                if (!value2.equals(1) && !value2.equals(4) && !value2.equals(3) && !value2.equals(5) && !value2.equals(6) && !value2.equals(7)) {
                    table.setValueAt(value2, rowIndex, colIndex);
                    table.setValueAt(value1, rowIndex - 1, colIndex);

                    table.repaint();

                    rowIndex--;
                }

            }
            if(x==3){
                Object value1 = table.getValueAt(rowIndex, colIndex);
                Object value2 = table.getValueAt(rowIndex + 1, colIndex);

                if (!value2.equals(1) && !value2.equals(4) && !value2.equals(3) && !value2.equals(5) && !value2.equals(6) && !value2.equals(7)) {
                    table.setValueAt(value2, rowIndex, colIndex);
                    table.setValueAt(value1, rowIndex + 1, colIndex);

                    table.repaint();

                    rowIndex++;
                }


            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


