/*
Given two version numbers, version1 and version2, compare them.
Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
*/
public class CompareVersionNumbers165 {
    public static void main(String[] args) {
        String version1 = "1.01", version2 = "1.001";
        System.out.println(compareVersion(version1, version2));

        String version3 = "1.0", version4 = "1.0.0";
        System.out.println(compareVersion(version3, version4));

        String version5 = "0.1", version6 = "1.1";
        System.out.println(compareVersion(version5, version6));

        String version7 = "1.0.1", version8 = "1";
        System.out.println(compareVersion(version7, version8));
    }

    public static int compareVersion(String version1, String version2) {
        String[] version1Strings = version1.split("\\."), version2Strings = version2.split("\\.");
        int version1Length = version1Strings.length, version2Length = version2Strings.length;
        int maxLength = Math.max(version1Length, version2Length);
        for (int i = 0; i < maxLength; i++) {
            int num1 = i < version1Length ? Integer.parseInt(version1Strings[i]) : 0;
            int num2 = i < version2Length ? Integer.parseInt(version2Strings[i]) : 0;
            if (num1 < num2) return -1;
            else if (num1 > num2) return 1;
        }
        return 0;
    }
}
