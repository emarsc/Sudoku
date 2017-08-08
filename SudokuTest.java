import java.io.*;
import java.util.*;


public class SudokuTest
{
	public static void main(String[] args)
	{
		int[][] board=new int[9][9];
try{	File file=new File("/Users/emars/Desktop/CS/sudoku/sudokuBoard.txt");
		Scanner boardRead=new Scanner(file);
		int r;
		int c;
		while(boardRead.hasNextInt())
		{
			r=boardRead.nextInt();
			c=boardRead.nextInt();
			board[r][c]=boardRead.nextInt();
		}
		boardRead.close();
}
catch(IOException e) { e.printStackTrace(); }

		Sudoku solver=new Sudoku(board);
		solver.visualize();
	/*	if(solver.exists(0, 3, 6))
		System.out.println("0 3 6");
		if(solver.exists(0, 3, 8))
		System.out.println("0, 3, 8");
		if(solver.exists(0, 3, 1))
		System.out.println("0, 3, 1"); */
		solver.solve();
		//System.out.println("I am not hung");
		//board=solver.solution();
		if(solver.isSolved(board))
		System.out.println("solved");
		solver.printBoard();

	}
}
