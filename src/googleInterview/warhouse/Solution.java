package googleInterview.warhouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 You are installing bomb to a war house with multiple rooms. The war house is designed such that between any two rooms,there is always a unique
 path. Each bomb can destroy a room, and all rooms adjacent to it. Return the minimum number of bombs needed to cover the war house.
 *
 *
 *
 * Example:
 *
 0 - 1 - 2 - 3 - 7
     |   |   |
     4   5   6

 Input:
 [
 {0, [1]},
 {1, [0, 2, 4]},
 {2, [1, 3, 5]},
 {3, [2]},
 {4, [1]},
 {5, [2]}
 ]

 Output:
 2
 */
public class Solution {
    private class Room {
        int number; // [0, N)
        List<Integer> adjacent;
        Room(int n) {
            number = n;
        }
    }

    private enum State {DESTROYED, LEAF, BOOM}

    public int solve(List<Room> rooms) {
        int[] res = {0};
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        State top = helper(rooms, 0, res, visited);
        if (top == State.LEAF) {
            res[0] += 1;
        }
        return res[0];
    }

    private State helper(List<Room> rooms, int cur, int[] res, boolean[] visited) {
        Room curRoom = rooms.get(cur);
        List<Integer> children = curRoom.adjacent;
        if (cur != 0 && children.size() == 1) {
            System.out.println("leaf " + cur);
            return State.LEAF;
        }

        State curState = State.LEAF;

        for (Integer v : children) {
            if (!visited[v]) {
                visited[v] = true;
                State state = helper(rooms, v, res, visited);
                if (state == State.LEAF) {
                    res[0] += 1;
                    return State.BOOM;
                }
                if (state == State.BOOM) {
                    curState = State.DESTROYED;
                }
            }
        }


        return curState;
    }

    /*
 0 - 1 - 2 - 3 - 7
     |   |   |
     4   5   6
     */
    public void test() {

        Room r0 = new Room(0);
        r0.adjacent = new ArrayList<>(Collections.singleton(1));

        Room r1 = new Room(1);
        r1.adjacent = new ArrayList<>(Arrays.asList(0, 2, 4));

        Room r2 = new Room(2);
        r2.adjacent = new ArrayList<>(Arrays.asList(1, 3, 5));

        Room r3 = new Room(3);
        r3.adjacent = new ArrayList<>(Arrays.asList(2, 6, 7));

        Room r4 = new Room(4);
        r4.adjacent = new ArrayList<>(Collections.singleton(1));

        Room r5 = new Room(5);
        r5.adjacent = new ArrayList<>(Collections.singleton(2));

        Room r6 = new Room(6);
        r6.adjacent = new ArrayList<>(Collections.singleton(3));

        Room r7 = new Room(7);
        r7.adjacent = new ArrayList<>(Collections.singleton(3));


        List<Room> rooms = new ArrayList<>(Arrays.asList(r0, r1, r2, r3, r4, r5, r6, r7));

        int res = solve(rooms);
        System.out.println(res);

    }

}
