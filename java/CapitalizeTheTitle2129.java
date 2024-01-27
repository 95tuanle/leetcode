/*
You are given a string title consisting of one or more words separated by a single space, where each word consists of English letters. Capitalize the string by changing the capitalization of each word such that:
If the length of the word is 1 or 2 letters, change all letters to lowercase.
Otherwise, change the first letter to uppercase and the remaining letters to lowercase.
Return the capitalized title.
*/
public class CapitalizeTheTitle2129 {
    public static void main(String[] args) {
        System.out.println(capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(capitalizeTitle("i lOve leetcode"));
    }

    public static String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (word.length() <= 2) stringBuilder.append(word.toLowerCase());
            else {
                stringBuilder.append(Character.toUpperCase(word.charAt(0)));
                stringBuilder.append(word.substring(1).toLowerCase());
            }
            stringBuilder.append(' ');
        }
        return stringBuilder.toString().trim();

//        int recentSpace = -1;
//        StringBuilder modified = new StringBuilder();
//        for (int i = 0; i < title.length(); i++) {
//            if (title.charAt(i) == ' ') {
//                int nextCharPos = recentSpace + 1;
//                if (i - (nextCharPos) == 1 || i - (nextCharPos) == 2)
//                    for (int j = nextCharPos; j < i; j++) modified.append(toLowerCaseWithoutBuiltIn(title.charAt(j)));
//                else {
//                    modified.append(toUpperCaseWithoutBuiltIn(title.charAt(nextCharPos)));
//                    for (int j = nextCharPos + 1; j < i; j++)
//                        modified.append(toLowerCaseWithoutBuiltIn(title.charAt(j)));
//                }
//                modified.append(' ');
//                recentSpace = i;
//            } else if (i == title.length() - 1) {
//                int nextCharPos = recentSpace + 1;
//                if (i - (nextCharPos) == 0 || i - (nextCharPos) == 1)
//                    for (int j = nextCharPos; j <= i; j++) modified.append(toLowerCaseWithoutBuiltIn(title.charAt(j)));
//                else {
//                    modified.append(toUpperCaseWithoutBuiltIn(title.charAt(nextCharPos)));
//                    for (int j = nextCharPos + 1; j <= i; j++)
//                        modified.append(toLowerCaseWithoutBuiltIn(title.charAt(j)));
//                }
//            }
//        }
//        return modified.toString();
    }

//    private static char toLowerCaseWithoutBuiltIn(char c) {
//        if (c >= 'A' && c <= 'Z') return (char) (c + ('a' - 'A'));
//        return c;
//    }
//
//    private static char toUpperCaseWithoutBuiltIn(char c) {
//        if (c >= 'a' && c <= 'z') return (char) (c - ('a' - 'A'));
//        return c;
//    }
}
