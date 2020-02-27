package googleInterview.maxlenSequenceIndataStream;

/*
* 1) data stream: 已给start, 求 sequence number 的最大值

是一个data stream，给了start number (e.g. 0)
data stream: 1, 2, 4  -> return 2
data stream: 1, 2, 3,4 -> return 4
* */

public class Solution {
    public void test() {
        DataStream2 ds = new DataStream2();
        ds.add(1);
        ds.add(2);
//        ds.add(3);
        ds.add(4);
        System.out.println(ds.maxSequence());
    }
}
