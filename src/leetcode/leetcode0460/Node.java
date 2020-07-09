package leetcode.leetcode0460;

public class Node {
    int key;
    int value;
    int visitCnt;
    int time;

    public Node (int key, int value, int time) {
        this.key = key;
        this.value = value;
        visitCnt = 1;
        this.time = time;
    }
}
