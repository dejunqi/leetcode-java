package advancedDataStructure.bipartiteGraphAndHungarianAlgorithm;

public class Solution {

    public void test() {
        int[][] graph = {
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0}};
        HungarianAlgo algo = new HungarianAlgo(graph);
        algo.search();
    }
}
