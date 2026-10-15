class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int loop[] : matrix) {
            if (loop[0] > target) {
                return false;
            }

            if(loop[loop.length-1] < target) {
                continue;
            }

            return search(loop, target);
        }
        return false;
    }

    public boolean search(int[] loop, int target) {
        int start = 0;
        int end = loop.length-1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(loop[mid] == target) {
                return true;
            } else if(loop[mid] > target) {
                end = mid -1;
            } else {
                start = mid+1;
            }
        }

        return false;
    }
}
