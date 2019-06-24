package advancedDataStructure.bipartiteGraphAndHungarianAlgorithm;

import java.util.HashSet;
import java.util.Set;

public class HungarianAlgo {

    int[][] graph; // 邻接矩阵. 每个顶点和它自己相连设置为 0
    int[] match;    // 记录每个顶点的匹配顶点, 如 match[0] = 1书名顶点 0 和顶点 1 已经匹配
    int len;        // 图的顶点个数

    public HungarianAlgo(int[][] graph) {
        this.graph = graph;
        len = graph.length;
        match = new int[len];
        for (int i = 0; i < len; i++) {
            match[i] = -1;
        }
    }

    public void search() {
        for (int i = len - 1; i >- 0; i--) {
            if (match[i] == -1) {
                // start allover again
                System.out.println("Start to match " + i);
                findAugmentPath(i, new HashSet<Integer>());
            }
        }

        System.out.println("\n");
        for (int i = 0; i < len; i++) {
            System.out.println(i + " ----> " + match[i]);
        }
    }

    // 寻找顶点 x 的增广路经, 如果能够找到, 则返回 true, 否则返回 false
    // 匈牙利算法的一个重要定理: 如果从一个顶点 A 出发, 没有找到怎光路径,
    // 那么无论再从别的点出发找到多少增广路经来改变现在的匹配，从A出发都永远找不到增广路径

    //如果顶点i还未匹配，或者与顶点i匹配的那个顶点可以换个顶点匹配（也就是说可以把顶点i“让给”当前顶点x），则把顶点x和顶点i为对方的匹配顶点
    //由于上一步已经将顶点i设置成used，所以findAugmentPath(match[i])不会再考虑顶点i了
    private boolean findAugmentPath(int x, Set<Integer> visited) {
        for (int i = 0; i < len; i++) {
            if (graph[x][i] == 1) { // 顶点 x 和 i相连接. 需要注意的一点是我们在输入需要计算的图的邻接矩阵的时候把对角线上的元素设置为0
                if (!visited.contains(i)) {
                    visited.add(i);
                    if (match[i] == -1 || findAugmentPath(match[i], visited)) {
                        match[x] = i;
                        match[i] = x;
                        System.out.println(x + " ---> " + i);
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
