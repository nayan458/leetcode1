class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        // int n = s.length();
        // int[] lps = LPS(goal);

        s = s + s;

        return s.indexOf(goal) != -1;
        // return kmp(s,goal,lps);
    }

    private boolean kmp(String s, String p, int[] lps) {

        int m = p.length(), n = s.length();
        int i = 0;
        int j = 0;

        while (i < n) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    return true;
                }
            }
            else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return false;
    }

    private int[] LPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int prefix = 0, curr = 1;
        while(curr < n) {
            if(s.charAt(prefix) == s.charAt(curr)) {
                prefix++;
                lps[curr] = prefix;
                curr++;
            } else {
                if(prefix == 0) {
                    lps[curr] = 0;
                    curr++;
                    continue;
                }
                prefix = lps[prefix-1];
            }
        }

        return lps;
    }
}