class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        return subSetsOfArray(nums, 0, ans);
    }

    public List<List<Integer>> subSetsOfArray(int[] nums, int index, List<Integer> ans) {
        if (index == nums.length) {
            List<List<Integer>> subSet = new ArrayList<>();
            subSet.add(new ArrayList<>(ans));
            return subSet;
        }

        ans.add(nums[index]);
        List<List<Integer>> left = subSetsOfArray(nums, index+1, ans);

        ans.remove(ans.size()-1);
        List<List<Integer>> right = subSetsOfArray(nums, index+1, ans);

        left.addAll(right);
        return left;
    }
}
