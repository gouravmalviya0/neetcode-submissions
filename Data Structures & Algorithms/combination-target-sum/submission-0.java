class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        return combinationSum(nums, 0, target, new ArrayList<>());
    }

    public List<List<Integer>> combinationSum(int[] nums, int index, int target,List<Integer> currentList) {
        if (target == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>(currentList);
            ans.add(list);
            return ans;
        }
        if(index == nums.length || target < 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> left = new ArrayList<>();
        for(int i=index;i<nums.length;i++) {
            List<Integer> internal = new ArrayList<>(currentList);
            internal.add(nums[i]);
            left.addAll(combinationSum(nums, i, target-nums[i], internal));

        }
        return left;
    }
}
