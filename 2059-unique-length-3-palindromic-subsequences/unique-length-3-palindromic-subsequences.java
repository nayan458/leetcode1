class Solution {
    Set<String> set = new HashSet<>();

    public int countPalindromicSubsequence(String s) {
        int[][] pre = new int[s.length()][26];
        int[][] pos = new int[s.length()][26];

        for(int i = 1; i < s.length(); i++) {
            System.arraycopy(pre[i-1], 0, pre[i], 0, 26);
            int index = (int) s.charAt(i-1) - 'a';
            pre[i][index] = 1;
        }

        for(int i = s.length() - 2; i >= 0; i--) {
            System.arraycopy(pos[i+1], 0, pos[i], 0, 26);
            int index = (int) s.charAt(i+1) - 'a';
            pos[i][index] = 1;
        }

        int count = 0;
        for(int i = 1; i < s.length()-1; i++){
            findIntersection(pre[i],pos[i],s.charAt(i));
            System.out.println(s.charAt(i) + " " + count);
        }

        return set.size();
    }

    private void findIntersection(int[] pre, int[] pos, char ch) {
        int count = 0;
        for(int i = 0; i < 26; i++){
            if((pre[i] & pos[i]) == 1) {
                char x = (char) ('a' + i);
                String result = "" + x + ch;
                set.add(result);
            }
        }
            // count += pre[i] & pos[i];
        
        // return count;
    }
}