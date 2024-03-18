import java.util.Arrays;
import java.util.Comparator;

/*
There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
*/
public class MinimumNumberOfArrowsToBurstBalloons452 {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}}));
        System.out.println(findMinArrowShots(new int[][]{{2, 3}, {2, 3}}));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(point -> point[0]));
        int result = points.length;
        int[] previous = points[0];
        for (int i = 1; i < points.length; i++)
            if (previous[1] >= points[i][0]) {
                result--;
                previous[0] = points[i][0];
                previous[1] = Math.min(previous[1], points[i][1]);
            } else previous = points[i];
        return result;
    }
}
