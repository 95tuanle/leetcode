import java.util.HashMap;

/*
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
*/
public class IsomorphicStrings205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>(), tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i), tChar = t.charAt(i);
            if (sMap.getOrDefault(sChar, tChar) != tChar || tMap.getOrDefault(tChar, sChar) != sChar) return false;
            sMap.put(sChar, tChar);
            tMap.put(tChar, sChar);
        }
        return true;

//        HashMap<Character, Character> sMap = new HashMap<>(), tMap = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (!sMap.containsKey(s.charAt(i)) && !tMap.containsKey(t.charAt(i))) {
//                sMap.put(s.charAt(i), t.charAt(i));
//                tMap.put(t.charAt(i), s.charAt(i));
//            } else if (sMap.containsKey(s.charAt(i)) && tMap.containsKey(t.charAt(i))) {
//                if (sMap.get(s.charAt(i)) != t.charAt(i) || tMap.get(t.charAt(i)) != s.charAt(i)) return false;
//            } else return false;
//        }
//        return true;
    }
}
