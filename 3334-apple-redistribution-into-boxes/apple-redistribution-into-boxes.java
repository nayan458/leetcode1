class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int totalApple = 0;

        for(int size: apple)
            totalApple += size;

        for(int i = capacity.length - 1; i >= 0; i--){
            totalApple -= capacity[i];
            if(totalApple <= 0) return capacity.length - i;
        }
        return capacity.length;
    }
}