class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    public void backtrack(int index, int[] nums,
                          List<Integer> current,
                          List<List<Integer>> result) {

        // store current subset
        result.add(new ArrayList<>(current));

        for(int i = index; i < nums.length; i++) {

            // choose
            current.add(nums[i]);

            // explore
            backtrack(i + 1, nums, current, result);

            // unchoose (backtrack)
            current.remove(current.size() - 1);
        }
    }
}