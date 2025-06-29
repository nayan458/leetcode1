class Solution {
    public int strStr(String haystack, String needle) {
        int s1 = haystack.length(), s2 = needle.length();

        if (s2 == 0) return 0;
        if (s2 > s1) return -1;

        for (int i = 0; i <= s1 - s2; i++) {
            int j = 0;
            while (j < s2 && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == s2) return i;
        }

        return -1;
    }
}
