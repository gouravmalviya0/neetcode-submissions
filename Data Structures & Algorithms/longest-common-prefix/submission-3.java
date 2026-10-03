class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        
        if (n == 1) 
            return strs[0];

        String longest = strs[0];
       
        for (int i = 1;i<n;i++) {
             int k = 0;
            longest = findCommonPrefix(longest, strs[i], k);
        }

        return longest;
    }

    private String findCommonPrefix(String str1, String str2, int k) {
        int len1 = str1.length();
        int len2 = str2.length();

        int min = len1 > len2 ? len2 : len1;
        String common = "";
        
        for(int i=0;i<min;i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                break;
            }
           k++;
        }

         return  str1.substring(0, k);
    }
}