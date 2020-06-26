//import leetcode.leetcode0273.Solution;

import java.util.Random;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        int min = 1;
        int max = 8;
        for (int i = 0; i < 20; i++) {
            System.out.println(rnd.nextInt(8 - 1 + 1) + 1);
        }
    }



}
