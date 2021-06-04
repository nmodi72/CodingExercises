package main.java.Impl.leetcode.year2019;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class KeysAndRoom {
    /*
    841. Keys and Rooms
    There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

    Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

    Initially, all the rooms start locked (except for room 0).

    You can walk back and forth between rooms freely.

    Return true if and only if you can enter every room.

    Example 1:

    Input: [[1],[2],[3],[]]
    Output: true
    Explanation:
    We start in room 0, and pick up key 1.
    We then go to room 1, and pick up key 2.
    We then go to room 2, and pick up key 3.
    We then go to room 3.  Since we were able to go to every room, we return true.
    Example 2:

    Input: [[1,3],[3,0,1],[2],[0]]
    Output: false
    Explanation: We can't enter the room with number 2.
    Note:

    1 <= rooms.length <= 1000
    0 <= rooms[i].length <= 1000
    The number of keys in all rooms combined is at most 3000.
     */
    Set<Integer> keys = new HashSet<>();
    boolean[] visited;
    public boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()) {
            int poll = q.poll();
            visited[poll] = true;
            for (int child : rooms.get(poll)) {
                if (!visited[child])
                    q.add(child);
            }
        }
        for (boolean b : visited)
            if (!b) return false;
        return true;
    }

    public boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        keys.add(0);
        int i = 0;
        while (i < rooms.size()) {
            if (!visited[i]) {
                if (!bfs(rooms, i)) return false;
            }
            i++;
        }
        return true;
    }

    private boolean bfs(List<List<Integer>> rooms, int node) {
        if (!keys.contains(node)) return false;
        if (visited[node]) return true;
        visited[node] = true;
        for (int child : rooms.get(node)) {
            keys.add(child);
            if(!bfs(rooms, child)) return false;
        }
        return true;
    }
}
