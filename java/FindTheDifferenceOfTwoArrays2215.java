import java.util.*;

/*
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.
*/
public class FindTheDifferenceOfTwoArrays2215 {
    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
        System.out.println(findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(findUniquesInFirst(nums1, nums2), findUniquesInFirst(nums2, nums1));
    }

    public static List<Integer> findUniquesInFirst(int[] nums1, int[] nums2) {
        Set<Integer> uniquesInFirst = new HashSet<>();
        Set<Integer> elementsInSecond = new HashSet<>();

        for (int num : nums2) elementsInSecond.add(num);

        for (int num : nums1) if (!elementsInSecond.contains(num)) uniquesInFirst.add(num);

        return new ArrayList<>(uniquesInFirst);
    }
}
