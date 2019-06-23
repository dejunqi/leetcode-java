package advancedDataStructure.segmentTree;

import java.util.Objects;

public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private SegmentTreeWorker<E> worker;

    public SegmentTree(E[] arr, SegmentTreeWorker<E> worker) {
        this.worker = worker;
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        return data[index];
    }

    // ql 与 qr 代表查询区间的左右边界
    public E query(int ql, int qr) {
        if (ql < 0 || ql >= data.length || qr < 0 || qr >= data.length || ql > qr) {
            throw new IllegalArgumentException("Illegal Index!");
        }
        return queryHelper(0, 0, data.length - 1, ql, qr);
    }


    public void update(int idx, E e) {
        if (idx < 0 || idx >= data.length) {
            throw new IllegalArgumentException("Illegal index.");
        }
        data[idx] = e;
        updateHelper(0, 0, data.length - 1, idx, e);
    }

    private void updateHelper(int treeIdx, int l, int r, int i, E e) {
        if (l == r) {
            tree[treeIdx] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftIdx = leftChild(treeIdx);
        int rightIdx = rightChild(treeIdx);
        if (i >= mid + 1) {
            updateHelper(rightIdx, mid + 1, r, i, e);
        } else {
            updateHelper(leftIdx, l, mid, i, e);
        }
        tree[treeIdx] = worker.merge(tree[leftIdx], tree[rightIdx]);
    }


    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // 在以 idx 为根的线段树中 [l ... r] 范围里, 搜索区间 [ql ... qr] 的信息
    private E queryHelper(int idx, int l, int r, int ql, int qr) {
        if (l == ql && r == qr) {
            return tree[idx];
        }
        int mid = l + (r - l) / 2;
        int leftIdx = leftChild(idx);
        int rightIdx = rightChild(idx);

        if (ql >= mid + 1) {
            return queryHelper(rightIdx, mid + 1, r, ql, qr);
        } else if (qr <= mid) {
            return queryHelper(leftIdx, l, mid, ql, qr);
        }

        E leftRes = queryHelper(leftIdx, l, mid, ql, mid);
        E rightRes = queryHelper(rightIdx, mid + 1, r, mid + 1, qr);

        return worker.merge(leftRes, rightRes);
    }


    // 在 treeIndex的位置创建表示区间 [l ... r] 的线段树
    private void buildSegmentTree(int idx, int l, int r) {
        if (l == r) {
            tree[idx] = data[l];
            return;
        }

        int leftTreeIdx = leftChild(idx);
        int rightTreeIdx = rightChild(idx);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIdx, l, mid);
        buildSegmentTree(rightTreeIdx, mid + 1, r);
        tree[idx] = worker.merge(tree[leftTreeIdx], tree[rightTreeIdx]);

    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }
            if (i != tree.length - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }


}
