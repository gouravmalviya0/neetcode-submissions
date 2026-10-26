class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2(candidates, 0, target, new ArrayList<>());
    }

    public List<List<Integer>> combinationSum2(int[] nums, int index, int target, List<Integer> currentList) {
        if (target < 0) {
            List<List<Integer>> ans = new ArrayList<>();
            return ans;
        }

        if (target == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>(currentList);
            ans.add(list);
            return ans;
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = index;i<nums.length;i++) {
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            } 
            //List<Integer> list = new ArrayList<>(currentList);
            currentList.add(nums[i]);
            ans.addAll(combinationSum2(nums, i+1, target - nums[i], currentList));
            currentList.remove(currentList.size()-1);
            

            
        }

        return ans;
    }
}
