package googleInterview.maxlenSequenceIndataStream;

import java.util.ArrayList;
import java.util.List;

public class DataStream2 {
    private List<Integer> list;
    private int curMax;
    private int start;

    public DataStream2() {
        list = new ArrayList<>();
        curMax = 0;
        start = 0;
    }

    public void add(int num) {
        if (list.size() == 0 || num - list.get(list.size() - 1) == 1) {
            list.add(num);
            curMax = Math.max(curMax, list.size() - start);
        } else {
            list.add(num);
            start = list.size() - 1;
        }
    }

    public int maxSequence() {
        return curMax;
    }
}
