package leetcode.leetcode0341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    private List<NestedInteger> list;
    private List<Integer> res;


    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>(nestedList);
        res = new ArrayList<>();
        flattern(res);
    }
    @Override
    public boolean hasNext() {
        return res.size() > 0;
    }

    @Override
    public Integer next() {
        return res.remove(0);
    }

    private void flattern(List<Integer> res) {
        while (list.size() > 0) {
            NestedInteger item = list.remove(0);
            if (item.isInteger()) {
                res.add(item.getInteger());
            } else {
                List<NestedInteger> innerList = item.getList();
                for (int i = innerList.size() - 1; i >= 0; i--) {
                    list.add(0, innerList.get(i));
                }
            }
        }
    }
}
