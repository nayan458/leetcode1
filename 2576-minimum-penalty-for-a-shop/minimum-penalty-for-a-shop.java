class Solution {
    public int bestClosingTime(String customers) {
        int max = 0;
        int idx = -1;
        int curr = 0;
        for(int i = 0; i < customers.length(); i++){
            char ch = customers.charAt(i);
            if(ch == 'N')   curr--;
            else    curr++;
            if(curr > max){
                idx = i;
                max = curr;
            }
        }
        return idx == -1 ? 0 : idx+1;
    }
}