class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int len = 1; len <=n/2; len++){
            if(n%len == 0){
                String pattern = s.substring(0, len);
                StringBuilder result = new StringBuilder();

                for(int i=0; i<n/len;i++){
                    result.append(pattern);
                }
                if(result.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}