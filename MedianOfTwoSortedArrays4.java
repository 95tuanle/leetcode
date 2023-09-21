import java.util.Arrays;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
*/
public class MedianOfTwoSortedArrays4 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] merged = new int[length];
        int i = 0;
        for (int j : nums1) {
            merged[i] = j;
            i++;
        }
        for (int j : nums2) {
            merged[i] = j;
            i++;
        }
        Arrays.sort(merged);
        if (length % 2 == 1) {
            return merged[length / 2];
        } else {
            return (double) (merged[length / 2 - 1] + merged[length / 2]) / 2;
        }
    }
}
