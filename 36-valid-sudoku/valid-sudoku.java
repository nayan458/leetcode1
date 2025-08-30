class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<Integer, Set<Character>> box = new HashMap<>();
        
        // Initialize maps
        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            box.put(i, new HashSet<>());
        }

        // Traverse board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char elem = board[i][j];
                if (elem == '.') continue;  // skip empty cells

                int boxIndex = (i / 3) * 3 + (j / 3);

                if (row.get(i).contains(elem) ||
                    col.get(j).contains(elem) ||
                    box.get(boxIndex).contains(elem)) {
                    return false;
                }

                row.get(i).add(elem);
                col.get(j).add(elem);
                box.get(boxIndex).add(elem);
            }
        }
        return true;
    }
}
