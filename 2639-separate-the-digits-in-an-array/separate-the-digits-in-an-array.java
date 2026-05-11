class Solution {
    private List<Integer> arr;

    public Solution() {
        this.arr = new ArrayList<>();
    }

    public int[] separateDigits(int[] nums) {
        for(int num: nums)
            addDigitsToList(num);
        int[] ans = this.arr.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        return ans;
    }

    private void addDigitsToList(int num) {
        List<Integer> digits = new ArrayList<>();
        while(num != 0) {
            int digit = num % 10;
            num /= 10;
            digits.add(digit);
        }
        Collections.reverse(digits);
        arr.addAll(digits);
    }
}