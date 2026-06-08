class Solution {
    private List<Integer> prev;
    private List<Integer> next;
    private int pivotCount;

    public Solution() {
        this.prev = new ArrayList<>();
        this.next = new ArrayList<>();
        this.pivotCount = 0;
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int result[] = new int[nums.length];
        for(int elem: nums) {
            if(elem == pivot)
                pivotCount++;
            else if(elem > pivot)
                next.add(elem);
            else
                prev.add(elem);
        }

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