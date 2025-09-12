class Solution {
    private static Set<Character> vowel = new HashSet<>(
        Arrays.asList('a', 'e', 'i', 'o', 'u')
    );

    public boolean doesAliceWin(String s) {
        List<Integer> arr = new ArrayList<>();
        int count = 0;
        int odd = 0, even = 0;

        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(vowel.contains(ch)) count++;
            else{
                if(count != 0){
                    arr.add(count);
                    if(count % 2 == 0)
                        even++;
                    else
                        odd++;
                    count = 0;
                }
            } 
        }
        if(count != 0){
            arr.add(count);
            if(count % 2 == 0)
                even++;
            else
                odd++;
            count = 0;
        }
        System.out.println(odd + even);
        return odd + even != 0;
    }
}