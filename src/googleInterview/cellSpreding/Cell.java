package googleInterview.cellSpreding;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    // number of points in this cell
    int points;
    private List<Cell> neighbors;
    public Cell(int p) {
        points = p;
        neighbors = new ArrayList<>();
    }
    // returns list of neighbor cells that are children of this cell
    List<Cell> getNeighbors() {
        return this.neighbors;
    }

    // spreads from this cell to the inputted cell
    // spreading is defined as moving all points from the current cell into a cell that has a value less than 1
    // the result is the spreader has 1 point and the spreadee has (spreader + spreadee - 1) points
    void spread(Cell cell) {
        List<Cell> neighbors = cell.getNeighbors();
        if (neighbors.size() == 0) {
            return;
        }
        int distributedPoint = points - 1;
        for (Cell c : neighbors) {
            if (distributedPoint <= c.points) {
                continue;
            }
            c.points += distributedPoint;
            c.spread(c);
        }
        points = 1;
    }

//    void spreadHelper(Cell cell, int p) {
//        List<Cell> neighbors = cell.getNeighbors();
//        if (neighbors == null || neighbors.size() == 0) {
//            return;
//        }
//        int N = neighbors.size();
//        int distributePoints = (points - 1) / N ;
//        for (Cell c : neighbors) {
//
//        }
//    }
}
