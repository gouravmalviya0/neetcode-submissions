class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i=0;i<=n;i++) {
            int count = 0;
            int no = i;
            while(no>0) {
                if((no&1) == 1) {
                    count++;
                }
                no = no >> 1;
            }
            arr[i] = count;
        }

        return arr;
    }
}
