import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant extra space.
*/
public class FindAllDuplicatesInAnArray442 {
    public static void main(String[] args) {
        FindAllDuplicatesInAnArray442 obj = new FindAllDuplicatesInAnArray442();
        System.out.println(obj.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(obj.findDuplicates(new int[]{1, 1, 2}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int abs = Math.abs(num);
            if (nums[abs - 1] < 0) list.add(abs);
            else nums[abs - 1] = -nums[abs - 1];
        }
        return list;
    }
}
