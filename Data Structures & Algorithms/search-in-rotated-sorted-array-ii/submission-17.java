class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        if(nums[start] < nums[end]) {
            return binarySearch(nums, start, end, target);
        }

        int peak = findPeak(nums);
        
        boolean result = binarySearch(nums, start, peak, target);

       if(!result){ 
            return  binarySearch(nums, peak+1, end, target);
       }
       return result;
       
    }

    int findPeak(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end) {
           int mid = start + (end - start)/2;

           if(mid < end && nums[mid] > nums[mid+1]) {
                return mid;
           }

           if(mid > start && nums[mid-1] > nums[mid]) {
                return mid-1;
           }


        // start mid & end are all equal but if start or end is pivot so return it otherwise ignore
           if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                if(start < end && nums[start] > nums[start+1]) {
                    return start;
                }

                if(end !=0 && nums[end-1] > nums[end]) {
                    return end-1;
                }

                start++;
                end--;
           }

           else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
             start = mid+1;
           } else {
             end = mid-1;
           }
        }

        return -1;
    } 

    boolean binarySearch(int[] nums, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end-start)/2;

            if(nums[mid] == target) {
                return true;
            } else if(nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}