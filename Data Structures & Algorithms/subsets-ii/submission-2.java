class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return subsetsWithDup(nums, 0, new ArrayList<>());
    }

    public List<List<Integer>> subsetsWithDup(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(list));
            return ans;
        }

        list.add(nums[index]);
        List<List<Integer>> left = subsetsWithDup(nums, index+1, list);
        list.remove(list.size()-1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        
            List<List<Integer>> right = subsetsWithDup(nums, index+1, list);
            left.addAll(right);
        
        
        return left;
    }
}
