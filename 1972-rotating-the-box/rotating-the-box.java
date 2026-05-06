class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        char[][] rotatedBox = new char[n][m];

        Map<int[],Integer> set = new HashMap<>();

        for(int i = 0; i < m; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                char ch = boxGrid[i][j];

                if(ch == '#')
                    count++;
                if(ch == '*') {
                    set.put(new int[]{j,i},count);
                    rotatedBox[j][i] = '*';
                    count = 0;
                } else {
                    rotatedBox[j][i] = '.';
                }
            }
            set.put(new int[]{n,i}, count);
        }

        for(Map.Entry<int[],Integer> entry: set.entrySet()) {
            int[] idx = entry.getKey();
            int i = idx[0], j = idx[1];
            int k = entry.getValue();
            // System.out.println(Arrays.toString(idx) + " : " + k);
            while(k-- != 0)
                rotatedBox[--i][j] = '#';
        }

        for(char[] row : rotatedBox)
            reverse(row);

        return rotatedBox;
    }

    private void reverse(char[] row) {
        
        int n = row.length;

        for(int i = 0; i < n/2; i++) {
            char temp = row[i];
            row[i] = row[n-i-1];
            row[n-i-1] = temp;            
        }

    }
}