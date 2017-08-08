import java.applet.*;
import java.awt.*;
import java.util.*;

public class SudokuVisualization extends Applet {
   public int[][] board=new int[9][9];
    public int[][] pre=new int[9][9];

    SudokuVisualization(Sudoku s) {
		board=s.getBoard();
		pre=s.pre;

    }
    public void init() {
        setSize(180, 180);
        setVisible(true);
    }


    public void paint(Graphics g) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                /* To paint the path */

                if (board[i][j] == 0)
                    g.setColor(Color.black);
                else
                    g.setColor(Color.white);

                g.fillRect(j * 40, i * 40, 40, 40);


                /* To paint the reachTime Grid */

                g.setColor(Color.black);
                g.setFont(new Font("Helvetica", Font.PLAIN, 16));

                g.drawString(String.valueOf(board[i][j]), j * 40 + 10, i * 40 + 20);
                g.drawRect(j * 40, i * 40, 40, 40);


                /* To paint the delayTime Grid */



            }
        }
    }
}
