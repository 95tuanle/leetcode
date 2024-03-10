import java.util.Arrays;
import java.util.HashSet;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique, and you may return the result in any order.
*/
public class IntersectionOfTwoArrays349 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result1 = intersection(nums1, nums2);
        for (int num : result1) System.out.print(num + " ");
        System.out.println();

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        int[] result2 = intersection(nums3, nums4);
        for (int num : result2) System.out.print(num + " ");
        System.out.println();
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num1 : nums1) hashSet.add(num1);
        int[] result = new int[hashSet.size()];
        int index = 0;
        for (int num2 : nums2)
            if (hashSet.contains(num2)) {
                result[index++] = num2;
                hashSet.remove(num2);
            }
        return Arrays.copyOf(result, index);
    }
}
