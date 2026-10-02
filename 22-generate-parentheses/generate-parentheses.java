class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0 , 0 ,n);
        return ans;
    }
    public void backtrack(List<String> ans, String current, int open, int close, int n){
        // base case
        if(open == n && close == n){
            ans.add(current);
            return;
        }
        // add (
        if(open < n){
            backtrack(ans, current + "(", open+1, close, n);
        }
        // add )
        if(close < open){
            backtrack(ans, current + ")", open, close+1, n);
        }
    }
}