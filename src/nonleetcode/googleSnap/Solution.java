package nonleetcode.googleSnap;

public class Solution {
    public void test() {
        Snapshot snp = new Snapshot(10);
        snp.set(0, 3);
        snp.set(1, 4);
        snp.set(2, 7);
        snp.snapshot();
        snp.set(1, 5);

        int v1 = snp.get(1, 1);
        int v2 = snp.get(1, 2);
        System.out.println(v1 + " --- " + v2);
    }
}
