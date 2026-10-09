class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int res = 0;
        int need = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                need += 2;

                if(need % 2 != 0){
                    res++;
                    need--;
                }
            }
            else{
                need--;
                if(need < 0){
                    res++;
                    need = 1;
                }
            }
        }
        return res + need;
    }
}