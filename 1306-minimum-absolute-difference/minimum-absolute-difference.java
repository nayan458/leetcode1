class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i+1 < arr.length; i++) 
            min = Math.min(min,Math.abs(arr[i] - arr[i+1]));
        for(int i = 0; i+1 < arr.length; i++)
            if(Math.abs(arr[i]-arr[i+1]) == min)
                ans.add(new ArrayList<>(List.of(arr[i],arr[i+1])));
        return ans;
    }
}