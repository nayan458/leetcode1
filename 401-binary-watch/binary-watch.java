class Solution {
    int[] val = {8,4,2,1,32,16,8,4,2,1};
    Set<String> set = new HashSet<>();
    public List<String> readBinaryWatch(int turnedOn) {
        backtracking(10,turnedOn,new ArrayList<>());
        set.remove("");
        return new ArrayList<>(set);
    }

    private void backtracking(int idx,int turnedOn, List<Integer> arr){
        if(idx == 0 && turnedOn > 0)
            return;
        if(turnedOn == 0) {
            set.add(Stringify(arr));
            return;
        }
        // add
        arr.add(idx-1);
        // operation
        backtracking(idx-1,turnedOn-1,arr);
        // remove
        arr.remove(arr.size()-1);
        backtracking(idx-1,turnedOn,arr);
    }

    String Stringify(List<Integer> arr){
        int hr = 0;
        int m = 0;
        for(int idx: arr)
            if(idx > 3)
                m += val[idx];
            else
                hr += val[idx];
        if(hr > 11 || m > 59)
            return "";
        StringBuilder str = new StringBuilder();
        str.append(String.valueOf(hr));
        str.append(':');
        if(m < 10) str.append('0');
        str.append(String.valueOf(m));
        return str.toString();        
    }
}