import java.util.ArrayList;
import java.util.List;

public class MajorityElementII229 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        List<Integer> list = majorityElement(nums);
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] nums2 = {3, 2, 3};
        List<Integer> list2 = majorityElement(nums2);
        for (int num : list2) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] nums3 = {1};
        List<Integer> list3 = majorityElement(nums3);
        for (int num : list3) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        for (int num : nums)
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        count1 = 0;
        count2 = 0;
        for (int num : nums)
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);
        return result;

//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int num : nums) hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
//        List<Integer> list = new ArrayList<>();
//        int n = nums.length;
//        for (int key : hashMap.keySet()) if (hashMap.get(key) > n / 3) list.add(key);
//        return list;
    }
}
