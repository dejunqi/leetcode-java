package leetcode0843;

public class Pair {
    String key;
    Integer val;
    Pair(String key, Integer value) {
        this.key = key;
        this.val = value;
    }
    public int getValue() {return this.val;}
    public String getKey() {return this.key;}
    public void print() {
        System.out.println("( " + this.key + ", " + this.val + " )");
    }

}
