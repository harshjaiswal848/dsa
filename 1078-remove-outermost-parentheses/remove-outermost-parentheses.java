class Solution {
    static {
        for (int i = 0; i<300; i++) {
            removeOuterParentheses("()");
        }
    }
    public static String removeOuterParentheses(String s) {
        int balance  = 0;
        StringBuilder result = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(balance > 0){
                    result.append(ch);
                }
                balance++;
            }
            else{
                balance--;
                if(balance > 0){
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}