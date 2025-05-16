class Solution {
    public List<String> validStrings(int n) {
        Queue<String> q = new LinkedList<>();
        List<String> arr = new ArrayList<>(); 

        q.add("1");
        q.add("0");

        while(!q.isEmpty()) {
            String str = q.remove();
            if(str.length() == n)
                arr.add(str);
            else {
                if(str.charAt(str.length() - 1) == '0')
                    q.add(str.concat("1"));
                else {
                    q.add(str.concat("1"));
                    q.add(str.concat("0"));
                }
            }
        }
        return arr;
    }
}