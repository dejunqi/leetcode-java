package dropbox.gameoflife;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Scanner;

public class GameOfLife {

    public void gameOfLife(int[][] board) { }

    public void processFile(String path) {
        int row = 3;
        int col = 1000000;
        Scanner scanner = null;
        int[][] board = new int[row][col];

        try {
            FileInputStream stream = new FileInputStream(path);
            scanner = new Scanner(stream);
            while (true) {
                for (int i = 0; i < row; i++) {
                    String line = scanner.nextLine();
                    if (line.length() == 0) {
                        return;
                    }

                    for (int j = 0; j < col; j++) {
                        board[i][j] = Character.getNumericValue(line.charAt(j));
                    }
                }

                gameOfLife(board);
                write(board, "data-" + (row - 3) + ".txt");
                row += 3;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void write(int[][] board, String path) {

        int row = board.length;
        int col = board[0].length;
        try {
            PrintWriter writer = new PrintWriter(path);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    sb.append(board[i][j]);
                    if (j == col - 1) {
                        sb.append("\n");
                    }
                }
            }

            writer.write(sb.toString());
            writer.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }



}
