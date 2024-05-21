import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
*/
public class Subsets78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> list : result) System.out.println(list);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : result)
                newSubsets.add(new ArrayList<>(subset) {{
                    add(num);
                }});
            result.addAll(newSubsets);
        }
        return result;
    }
}
