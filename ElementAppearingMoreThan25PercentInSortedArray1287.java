/*
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
*/
public class ElementAppearingMoreThan25PercentInSortedArray1287 {
    public static void main(String[] args) {
        System.out.println(findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
        System.out.println(findSpecialInteger(new int[]{1, 1}));
    }

    public static int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int span = n / 4;
        for (int i = 0; i < n - span; i++) {
            if (arr[i] == arr[i + span]) {
                return arr[i];
            }
        }
        return -1;

//        if (arr.length == 1) return arr[0];
//        double twentyFivePercentTimes = (double) (25 * arr.length) / 100;
//        if (twentyFivePercentTimes < 1) return arr[0];
//        int current = arr[0];
//        int currentTimes = 1;
//        for (int i = 1; i < arr.length - 1; i++)
//            if (arr[i] == current) {
//                currentTimes++;
//                if (currentTimes > twentyFivePercentTimes) return current;
//            } else {
//                current = arr[i];
//                currentTimes = 1;
//            }
//        return -1;
    }
}
