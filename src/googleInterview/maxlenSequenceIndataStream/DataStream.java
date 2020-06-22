package googleInterview.maxlenSequenceIndataStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStream {

    private Map<Integer, List<Integer>> map;
    private int curMax;

    public DataStream() {
        map = new HashMap<>();
        map.put(0, new ArrayList<>());
        curMax = 0;
    }

    public void add(int num) {
        for (int idx : map.keySet()) {
            List<Integer> list = map.get(idx);
            if (list.size() == 0 || num - list.get(list.size() - 1) == 1) {
                list.add(num);
                curMax = Math.max(curMax, list.size());
                return;
            }
        }
        map.put(map.size(), new ArrayList<>(num));
        curMax = Math.max(curMax, 1);
    }

    public int maxSequence() {
        return curMax;
    }
}
