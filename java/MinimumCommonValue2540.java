/*
Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.
Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
*/
public class MinimumCommonValue2540 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {2, 3, 4, 5, 6};
        System.out.println(getCommon(nums1, nums2));

        int[] nums3 = {1, 2, 3, 4, 5};
        int[] nums4 = {6, 7, 8, 9, 10};
        System.out.println(getCommon(nums3, nums4));

        int[] nums5 = {1, 2, 3, 4, 5};
        int[] nums6 = {1, 2, 3, 4, 5};
        System.out.println(getCommon(nums5, nums6));
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        if (nums1[0] > nums2[l2 - 1] || nums2[0] > nums1[l1 - 1]) return -1;
        int p1 = 0, p2 = 0;
        while (p1 < l1 && p2 < l2) {
            if (nums1[p1] == nums2[p2]) return nums1[p1];
            else if (nums1[p1] < nums2[p2]) p1++;
            else p2++;
        }
        return -1;
    }
}
