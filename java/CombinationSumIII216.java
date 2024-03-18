import java.util.ArrayList;
import java.util.List;

/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
*/
public class CombinationSumIII216 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(4, 1));
        System.out.println(combinationSum3(3, 2));
        System.out.println(combinationSum3(9, 45));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(1, k, n, result, new ArrayList<>());
        return result;
    }

    private static void backtracking(int start, int k, int n, List<List<Integer>> result, ArrayList<Integer> current) {
        if (k < 0 || n < 0) return;
        if (k == 0 && n == 0) result.add(new ArrayList<>(current));
        else for (int i = start; i <= 9 && i <= n; i++) {
            current.add(i);
            backtracking(i + 1, k - 1, n - i, result, current);
            current.removeLast();
        }
    }
}
