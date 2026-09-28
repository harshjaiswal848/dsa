class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxCount = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                count++;
                maxCount = Math.max(maxCount, count);
            }
            else if(ch == ')'){
                count--;
            }
        }
        return maxCount;
    }
}