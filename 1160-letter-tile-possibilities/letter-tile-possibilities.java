class Solution {
    int tile[] = new int[26];
    public int numTilePossibilities(String tiles) {
        
        for(int i = 0; i < tiles.length(); i++)
            tile[tiles.charAt(i) - 'A'] += 1;

        return backtracking(tile);
    }
    private int backtracking(int[] tile){
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(tile[i] == 0) continue;
            tile[i]--;
            count = count + 1 + backtracking(tile);
            tile[i]++;
        }
        return count;
    }
}