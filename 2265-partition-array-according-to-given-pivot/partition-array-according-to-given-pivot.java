class Solution {
    private List<Integer> prev;
    private List<Integer> next;
    private int pivotCount;

    public Solution() {
        this.pivotCount = 0;
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int result[] = new int[nums.length];
        for(int elem: nums) {
            if(elem == pivot)
                pivotCount++;
        }
        prev = Arrays.stream(nums)
            .filter(x -> x < pivot)
            .boxed()
            .toList();
        next = Arrays.stream(nums)
            .filter(x -> x > pivot)
            .boxed()
            .toList();

        int i = 0;

        for(int elem: prev)
            nums[i++] = elem;

        while(pivotCount-- != 0)
            nums[i++] = pivot;

        for(int elem: next)
            nums[i++] = elem;

        return nums;
    }
}