import java.util.*;
import javax.swing.*;

public class Sudoku
{
	public int[][] b=new int[9][9];
	int[][] pre=new int[9][9];
	int[][] check=new int[27][9]; //-boxes are 0-8 are row/3*3+c/3 -rows are rows*2 and columns are columns *3 -value is 0-8
	public LinkedList<Integer>[][] board;
	int counter=0; //counter to control recursion
	int flag;
	boolean[][] mark=new boolean[9][9];
	int temp;
	public SudokuVisualization visual;
	public Sudoku()
	{

	}
@SuppressWarnings("unchecked")
	public Sudoku(int[][] p)
	{

		board=new LinkedList[9][9];

		pre=p;
		int v;
		for(int r=0; r<9; r++)
		{
			for(int c=0; c<9; c++) {
			board[r][c]=new LinkedList<Integer>();
			v=p[r][c];

			if(v!=0) {
				addS(r, c, v);
				mark[r][c]=true;
			}

		}
		}

	}

public void solve()  //the big one
{	flag=1;
	int count=-1;
	counter++;
	int c=0;
	int r=0;
	while(count<80)
	{
		count=count+flag;
		r=count/9;
		c=count%9;
		while(pre[r][c]!=0 && count<81)
		{
			count=count+flag;
			r=count/9;
			c=count%9;
		}
		if(flag<0)
		removeS(r, c, b[r][c]);

		if(count<0)
		System.out.println("COUNT ALERT: "+count);

		flag=-1;
		for(int i=b[r][c]; i<9; i++)
		{
			if(!exists(r, c, b[r][c]+1))
			{
				flag=1;
				addS(r, c, b[r][c]+1);
				break;
			}
			else
				b[r][c]++;
		}
			if(flag<0)
				b[r][c]=0;
	}
}

public void addS(int r, int c, int v)
{
	check[(r/3)*3+(c/3)][v-1]=1;
	check[9+r][v-1]=1;
	check[18+c][v-1]=1;
	b[r][c]=v;
}
public void removeS(int r, int c, int v)
{
		check[(r/3)*3+(c/3)][v-1]=0;
		check[9+r][v-1]=0;
		check[18+c][v-1]=0;
		/*if(c==8)
		{
			b[r+1][0]=0;
		}
		else
			b[r][c+1]=0; */
}

public int[][] getBoard() //returns board in whatever condition
{
	return b;
}
public boolean isSolved(int[][] s)
{
	for(int i=0; i<27; i++)
	{
		for(int j=0; j<9; j++)
		{
			if(check[i][j]!=1)
				return false;
		}
	}
	return true;
}

public boolean exists(int r, int c, int v)
{
	if(check[(r/3)*3+(c/3)][v-1]==1 || check[r+9][v-1]==1 || check[c+18][v-1]==1)
		return true;
 return false;
}
    public void show() {
        // Don't Change this part, it's visualize Part
         try {
            Thread.sleep(1000);
            //count++;
            //if (count == 5) Thread.sleep(20000);
            visual.repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //TODO: Start your implementation of progress here
    }

    public void visualize() {
        visual = new SudokuVisualization(this);

        JFrame frame = new JFrame("Sudoku Visual");
        frame.add(visual);
        visual.init();
        visual.start();
        frame.setSize(visual.getSize());
        frame.setVisible(true);
    }
public void printBoard()
{
	for(int i=0; i<9; i++)
	{
		System.out.println();
		for(int j=0; j<9; j++)
		{
			System.out.print(b[i][j]+" ");
		}
	}
	System.out.println("Counter: "+counter+" Temp: "+temp);
}

}