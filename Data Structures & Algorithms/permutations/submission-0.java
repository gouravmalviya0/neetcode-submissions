class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, 0,new ArrayList<>(), ans);
        return ans;
    }

    public void permute(int[] nums, int index, List<Integer> current, List<List<Integer>> ans) { 
        if (nums.length == index) {
             ans.add(new ArrayList<>(current));
             return;
        }

        int no = nums[index];
        for(int i = 0;i<=index;i++) {
            List<Integer> newList = new ArrayList<>(current);
            newList.add(i, no);
            permute(nums, index+1, newList, ans);
        }
    }
}
