# Given two version numbers, version1 and version2, compare them. Version numbers consist of one or more revisions
# joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at
# least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0,
# the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers. To compare
# version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value
# ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not
# specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1
# because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
def compareVersion(version1: str, version2: str) -> int:
    version1_strings, version2_strings = version1.split('.'), version2.split('.')
    version1_length, version2_length = len(version1_strings), len(version2_strings)
    max_length = max(version1_length, version2_length)
    for i in range(max_length):
        num1, num2 = int(version1_strings[i]) if i < version1_length else 0, int(
            version2_strings[i]) if i < version2_length else 0
        if num1 < num2:
            return -1
        elif num1 > num2:
            return 1
    return 0


if __name__ == '__main__':
    print(compareVersion('1.01', '1.001'))  # 0
    print(compareVersion('1.0', '1.0.0'))  # 0
    print(compareVersion('0.1', '1.1'))  # -1
    print(compareVersion('1.0.1', '1'))  # 1
