package dropbox.gameoflife;

import java.io.*;

public class Solution {

    public void gameoflife() {
        int r = 0;
        int c = 0;
        int pagination = 100;

        while (true) {
            File file = read(r, c, pagination);
            if (file == null) {
                r += pagination;
                c = 0;
                file = read(r, c, pagination);
                if (file == null) {
                    break;
                }
            }
            write("/", file);
            c += pagination;
        }
    }


    private File read(int startRow, int starCol, int pagination) {

        // give a a text file with a matrix of m X n
        // where m = startRow + pagination, n = startCol  + pagination
        // Repeatly invoke this function startfrom from startRow = startCol = 0, and pagination = 100
        // 1st call --> 0 ~ 99 row and col
        // 2ned call --> row from (0, 99) col from (100 ~ 199)
        return new File("/");
    }

    private void write(String path, File file) {
        // compute and then write the result intto a file
    }




}
