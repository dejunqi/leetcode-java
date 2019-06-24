package advancedDataStructure.segmentTree;



public class Solution {

    public void test() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> seg = new SegmentTree<>(nums, (a, b) -> a + b);

//        System.out.println(seg);

        Integer res = seg.query(2, 5);
        System.out.println(res);
    }
}
