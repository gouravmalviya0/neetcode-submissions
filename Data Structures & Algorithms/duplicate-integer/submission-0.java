class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean isPresent = false;
        for(int i=0;i<nums.length; i++) {
            if (set.contains(nums[i])) {
                isPresent = true;
                break;
            }
            set.add(nums[i]);
        }
        return isPresent;
    }
}