package dropbox.gameoflife;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Scanner;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
    }

    private void processFile(String filename) {

        Scanner scanner = null;
        int N = 1000000;
        int[][] board = new int[3][N];


        try {
            File file = new File(filename);
            if (!file.exists()) {
                throw new IllegalArgumentException("No such dir");
            }

            FileInputStream fis = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
            int M = 3;
            while (true) {
                for (int i = 0; i < M; i++) {
                    String line = scanner.nextLine();

                    if (line.length() == 0) return;

                    for (int j = 0; j < N; j++) {
                        board[i][j] = Character.getNumericValue(line.charAt(j));
                    }
                }

                gameOfLife(board);
                writeFile(board, "data-" + (M - 3) + ".txt");
                M += 3;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void writeFile(int[][] board, String path) {

        try {
            PrintWriter writer = new PrintWriter(path);
            int row = 3;
            int col = 1000000;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    char c = (char)board[i][j];
                    sb.append(c);
                    if (j == col - 1) {
                        sb.append("\n");
                    }
                }
            }

            String data = sb.toString();
            writer.print(data);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
