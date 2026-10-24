class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        return subSetsOfArray(nums, 0, ans);
    }

    public List<List<Integer>> subSetsOfArray(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            return ans;
        }

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<ans.size();i++) {
            List<Integer> subList = new ArrayList<>(ans.get(i));
            subList.add(nums[index]);
            list.add(subList);
        }

        List<List<Integer>> left = subSetsOfArray(nums, index+1, list);
        List<List<Integer>> right = subSetsOfArray(nums, index+1, ans);

        left.addAll(right);
        return left;
    }
}
