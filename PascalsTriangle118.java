import java.util.ArrayList;
import java.util.List;

/*
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it, as shown:
*/
public class PascalsTriangle118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate(1));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++)
                row.add(result.get(result.size() - 1).get(j) + result.get(result.size() - 1).get(j - 1));
            row.add(1);
            result.add(row);
        }
        return result;

//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < numRows; i++) {
//            List<Integer> row = new ArrayList<>(i + 1);
//            row.add(1);
//            for (int j = 1; j < i; j++) row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
//            if (i > 0) row.add(1);
//            result.add(row);
//        }
//        return result;
    }
}
