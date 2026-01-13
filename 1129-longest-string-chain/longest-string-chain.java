class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int n = words.length;
        int dp [] = new int[n];
        Arrays.fill(dp,1);
        int ans = 1;
        //compare i >j
        for(int i=0; i <n;i++){
            for(int j=0;j<i;j++){
                if(words[i].length() - words[j].length() != 1){
                    continue;
                }
                //check whether j is valid predecessor of i
                if(pred(words[j],words[i])){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    private boolean pred(String shortW, String longW){
        int i=0, j=0;
        while(i <shortW.length() && j <longW.length()){
            if(shortW.charAt(i) == longW.charAt(j)){
                i++;
            }
            j++;
        }
        return i==shortW.length();
    }
}