class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        char[][] pyramid = createPyramid(bottom);
        Map<String,List<Character>> hm = createAllowedMap(allowed);

        return backtracking(pyramid.length - 2, 0, pyramid, hm);
    }

    private boolean backtracking(int row, int col, char[][] pyramid, Map<String, List<Character>> hm) {
        // if we finished the top row successfully
        if (row < 0) return true;

        // if we finished this row, move one row up
        if (col > row) {
            return backtracking(row - 1, 0, pyramid, hm);
        }

        char left = pyramid[row + 1][col];
        char right = pyramid[row + 1][col + 1];
        String key = "" + left + right;

        // no allowed transition → dead end
        if (!hm.containsKey(key)) return false;

        // try all possible characters at pyramid[row][col]
        for (char ch : hm.get(key)) {
            pyramid[row][col] = ch;

            if (backtracking(row, col + 1, pyramid, hm)) {
                return true;
            }
        }

        // all options failed
        return false;
    }

    private Map<String,List<Character>> createAllowedMap(List<String> allowed){
        Map<String,List<Character>> hm = new HashMap<>();
        for(String type: allowed){
            String s = type.substring(0,2);
            char ch = type.charAt(2);

            hm.computeIfAbsent(s, k -> new ArrayList<>()).add(ch);
        }
        return hm;
    }

    private char[][] createPyramid(String bottom) {
        int n = bottom.length();
        char[][] pyramid = new char[n][];

        for(int i = 1; i <= n; i++)
            pyramid[(i-1)] = new char[i];

        for(int i = 0; i < n; i++)
            pyramid[n - 1][i] = bottom.charAt(i);
        return pyramid;
    }

    private void printPyramid(char[][] pyramid) {
        for(char[] row: pyramid){
            for(char ch: row)
                System.out.print(ch + "?");
            System.out.println();
        }
    }
}