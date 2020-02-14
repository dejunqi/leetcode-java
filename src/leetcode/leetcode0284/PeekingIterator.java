package leetcode0284;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer nextItem = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        nextItem = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextItem;
    }

    @Override
    public boolean hasNext() {
        return nextItem != null;
    }

    @Override
    public Integer next() {
        Integer res = nextItem;
        nextItem = null;
        if (iterator.hasNext()) {
            nextItem = iterator.next();
        }
        return res;
    }

}
