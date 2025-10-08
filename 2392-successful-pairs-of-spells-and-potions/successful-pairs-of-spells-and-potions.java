class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pair = new int[spells.length];
        for(int i = 0; i < spells.length; i++){
            pair[i] = potions.length - binary_search(potions, spells[i], success);
        }

        return pair;
    }

    private int binary_search(int[] potions, int spell, long target){
        int l = 0; int r = potions.length - 1;
        int num = potions.length;
        while(l <= r){
            int mid = l + ((r - l) / 2);
            long product = (long) spell * potions[mid];
            if(product < target){
                l = mid + 1;
            }
            else{
                r = mid - 1;
                num = mid;
            }
        }

        return num;
    }
}