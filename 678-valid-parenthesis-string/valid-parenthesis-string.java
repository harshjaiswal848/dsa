class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int min = 0;
        int max = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                min++;
                max++;
            }
            else if(s.charAt(i) == ')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            min = Math.max(min, 0);

            if(max < 0){
                return false;
            }
        }
        return min == 0;
    }
}