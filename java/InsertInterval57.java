import java.util.ArrayList;
import java.util.Arrays;

/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.
Note that you don't need to modify intervals in-place. You can make a new array and return it.
*/
public class InsertInterval57 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        System.out.println(Arrays.deepToString(insert(new int[][]{}, new int[]{5, 7})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{2, 3})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{2, 7})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{6, 8})));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) result.add(intervals[i++]);
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);
        while (i < intervals.length) result.add(intervals[i++]);
        return result.toArray(new int[result.size()][]);

//        ArrayList<int[]> result = new ArrayList<>();
//        for (int[] interval : intervals) {
//            if (newInterval == null || interval[1] < newInterval[0]) result.add(interval);
//            else if (interval[0] > newInterval[1]) {
//                result.add(newInterval);
//                result.add(interval);
//                newInterval = null;
//            } else {
//                newInterval[0] = Math.min(interval[0], newInterval[0]);
//                newInterval[1] = Math.max(interval[1], newInterval[1]);
//            }
//        }
//        if (newInterval != null) result.add(newInterval);
//        return result.toArray(new int[result.size()][]);

//        if (intervals.length == 0) return new int[][]{newInterval};
//        int n = intervals.length, target = newInterval[0], left = 0, right = n - 1;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (intervals[mid][0] < target) left = mid + 1;
//            else right = mid - 1;
//        }
//        ArrayList<int[]> arrayList = new ArrayList<>();
//        for (int i = 0; i < left; i++) arrayList.add(intervals[i]);
//        arrayList.add(newInterval);
//        for (int i = left; i < n; i++) arrayList.add(intervals[i]);
//        ArrayList<int[]> result = new ArrayList<>();
//        for (int[] interval : arrayList) {
//            if (result.isEmpty() || result.getLast()[1] < interval[0]) result.add(interval);
//            else result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
//        }
//        return result.toArray(new int[result.size()][]);
    }
}
