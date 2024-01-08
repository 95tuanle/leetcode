
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
*/
public class KeysAndRooms841 {
    public static void main(String[] args) {
        System.out.println(canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
        System.out.println(canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0))));
        System.out.println(canVisitAllRooms(List.of(List.of(2), List.of(), List.of(1))));
//        [[6,7,8],[5,4,9],[],[8],[4],[],[1,9,2,3],[7],[6,5],[2,3,1]]
        System.out.println(canVisitAllRooms(List.of(List.of(6, 7, 8), List.of(5, 4, 9), List.of(), List.of(8), List.of(4), List.of(), List.of(1, 9, 2, 3), List.of(7), List.of(6, 5), List.of(2, 3, 1))));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int room = queue.poll();
            for (int key : rooms.get(room))
                if (!visited[key]) {
                    visited[key] = true;
                    queue.offer(key);
                }
        }
        for (boolean visit : visited) if (!visit) return false;
        return true;
    }

//    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        if (rooms.isEmpty()) return false;
//        boolean[] visited = new boolean[rooms.size()];
//        Set<Integer> keys = new HashSet<>();
//        visited[0] = true;
//        for (int i = 0; i < rooms.size(); i++) {
//            if (visited[i]) {
//                update(rooms, visited, keys, i);
//            } else {
//                if (keys.contains(i)) {
//                    visited[i] = true;
//                    update(rooms, visited, keys, i);
//                }
//            }
//        }
//        for (boolean visit : visited) {
//            if (!visit) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static void update(List<List<Integer>> rooms, boolean[] visited, Set<Integer> keys, int i) {
//        for (int key : rooms.get(i)) {
//            if (keys.add(key)) {
//                visited[key] = true;
//                for (int k : rooms.get(key)) {
//                    if (keys.add(k)) {
//                        visited[k] = true;
//                    }
//                }
//            }
//        }
//    }
}
