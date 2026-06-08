class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        IntStream less = Arrays.stream(nums)
                            .filter(x -> x < pivot);

        IntStream equal = Arrays.stream(nums)
                                .filter(x -> x == pivot);

        IntStream greater = Arrays.stream(nums)
                                .filter(x -> x > pivot);

        return IntStream.concat(
                IntStream.concat(less, equal),
                greater
        ).toArray();
    }
}