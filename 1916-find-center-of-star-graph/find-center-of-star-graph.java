class Solution {
    public int findCenter(int[][] edges) {
        int u1 = edges[0][0];
        int u2 = edges[0][1];
        int v1 = edges[1][0];
        int v2 = edges[1][1];
        if(u1 == v1 || u1 == v2){
            return u1;
        }
        return u2;
    }
}