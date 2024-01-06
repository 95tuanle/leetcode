import java.util.ArrayList;
import java.util.List;

/*
You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
The 2D array should contain only the elements of the array nums.
Each row in the 2D array contains distinct integers.
The number of rows in the 2D array should be minimal.
Return the resulting array. If there are multiple answers, return any of them.
Note that the 2D array can have a different number of elements on each row.
*/
public class ConvertAnArrayIntoA2DArrayWithConditions2610 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(findMatrix(nums));
        int[] nums1 = {1, 3, 4, 1, 2, 3, 1};
        System.out.println(findMatrix(nums1));
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        int[] frequency = new int[nums.length + 1];
        List<List<Integer>> result = new ArrayList<>();
        for (int num : nums) {
            if (frequency[num] >= result.size()) result.add(new ArrayList<>());
            result.get(frequency[num]).add(num);
            frequency[num]++;
        }
        return result;

//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        for (int num : nums) {
//            if (!result.isEmpty()) {
//                boolean added = false;
//                for (List<Integer> list : result) {
//                    if (!list.contains(num)) {
//                        list.add(num);
//                        added = true;
//                        break;
//                    }
//                }
//                if (!added) {
//                    if (temp.contains(num)) {
//                        result.add(temp);
//                        temp = new ArrayList<>();
//                    }
//                    temp.add(num);
//                }
//            } else {
//                if (temp.contains(num)) {
//                    result.add(temp);
//                    temp = new ArrayList<>();
//                }
//                temp.add(num);
//            }
//        }
//        result.add(temp);
//        return result;
    }
}
