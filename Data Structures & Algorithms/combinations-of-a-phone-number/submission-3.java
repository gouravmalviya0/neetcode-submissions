class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return  new ArrayList<>();
        return findAllCombination(digits, "", digits.length());
    }

    public List<String> findAllCombination(String digits, String p, int n) {
        if(p.length() == n) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int no = digits.charAt(0) - '0';
        int start = no > 7 ? ((no-2)*3)+2 : ((no-2)*3)+1;
        int end = no >= 7 ? (((no-1) * 3) + 1) : ((no-1) * 3);
        List<String> list = new ArrayList<>();
        for(int i = start; i <= ((no == 9) ? end+1 : end); i++) {
            char ch = (char)('a' + (i-1));
            list.addAll(findAllCombination(digits.substring(1), p + ch, n));
        }
    
        return list;
    }
}
