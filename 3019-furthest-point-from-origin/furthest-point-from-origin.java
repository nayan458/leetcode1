class Solution {

    public int furthestDistanceFromOrigin(String moves) {
        int count = 0;
        int extra = 0;

        for(int i = 0; i < moves.length(); i++){
            char dir = moves.charAt(i);
            if(dir == 'L')
                count--;
            else if(dir == 'R')
                count++;
            else
                extra++;
        }
        
        return Math.abs(count) + extra;
    }
}