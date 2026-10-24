class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0,new ArrayList<>());
    }

    public List<List<Integer>> permute(int[] nums, int index, List<Integer> current) { 
        if (nums.length == index) {
            List<List<Integer>> ans = new ArrayList<>();
             ans.add(new ArrayList<>(current));
             return ans;
        }

        int no = nums[index];
        List<List<Integer>> permutation = new ArrayList<>();
        for(int i = 0;i<=index;i++) {
            List<Integer> newList = new ArrayList<>(current);
            newList.add(i, no);
            permutation.addAll(permute(nums, index+1, newList));
        }
        return permutation;
    }
}
