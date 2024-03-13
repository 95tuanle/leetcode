import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
*/
public class LetterCombinationsOfAPhoneNumber17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        HashMap<Character, String> hashMap = new HashMap<>();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        backtrack(digits, hashMap, result, 0, new StringBuilder());
        return result;
    }

    private static void backtrack(String digits, HashMap<Character, String> hashMap, List<String> result, int i, StringBuilder stringBuilder) {
        if (stringBuilder.length() == digits.length()) result.add(stringBuilder.toString());
        else for (char c : hashMap.get(digits.charAt(i)).toCharArray()) {
            stringBuilder.append(c);
            backtrack(digits, hashMap, result, i + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
