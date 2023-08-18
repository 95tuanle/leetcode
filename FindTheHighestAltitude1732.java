/*
There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
*/
public class FindTheHighestAltitude1732 {
    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }

    public static int largestAltitude(int[] gain) {
        int largest = 0;
        int current = largest;
        for (int g : gain) {
            current += g;
            largest = Math.max(current, largest);
        }
        return largest;
    }
}
