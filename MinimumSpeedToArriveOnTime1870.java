/*
You are given a floating-point number hour, representing the amount of time you have to reach the office. To commute to the office, you must take n trains in sequential order. You are also given an integer array dist of length n, where dist[i] describes the distance (in kilometers) of the ith train ride.
Each train can only depart at an integer hour, so you may need to wait in between each train ride.
For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours before you can depart on the 2nd train ride at the 2-hour mark.
Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you to reach the office on time, or -1 if it is impossible to be on time.
Tests are generated such that the answer will not exceed 107 and hour will have at most two digits after the decimal point.
*/

public class MinimumSpeedToArriveOnTime1870 {
    public static void main(String[] args) {
        System.out.println(minSpeedOnTime(new int[]{1, 3, 2}, 6));
        System.out.println(minSpeedOnTime(new int[]{1, 3, 2}, 2.7));
        System.out.println(minSpeedOnTime(new int[]{1, 3, 2}, 1.9));
        System.out.println(minSpeedOnTime(new int[]{1, 1, 100000}, 2.01));
        System.out.println(minSpeedOnTime(new int[]{2, 1, 5, 4, 4, 3, 2, 9, 2, 10}, 75.12));
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (hour <= n - 1) {
            return -1;
        }
        int min = 1;
        int max = 10000000;
        while (min < max) {
            int mid = min + (max - min) / 2;
            double time = 0;
            for (int i = 0; i < n - 1; i++) {
                time += Math.ceil((double) dist[i] / mid);
            }
            time += (double) dist[n - 1] / mid;
            if (time <= hour) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;

//        int n = dist.length;
//        if (n - 1 >= hour)
//            return -1;
//        int minSpeed = 1;
//        int maxSpeed = 10000000;
//        while (minSpeed <= maxSpeed) {
//            double time = 0;
//            for (int i = 0; i < n - 1; i++) {
//                if (dist[i] % minSpeed == 0)
//                    time += (int) ((double) dist[i] / minSpeed);
//                else
//                    time += (int) ((double) dist[i] / minSpeed) + 1;
//            }
//            time += (double) dist[n - 1] / minSpeed;
//            if (time <= hour)
//                return minSpeed;
//            minSpeed++;
//        }
//        return -1;
    }
}