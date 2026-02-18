class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<long[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] road:roads){
            int u=road[0];
            int v=road[1];
            int time=road[2];
            graph.get(u).add(new long[]{v,time});
            graph.get(v).add(new long[]{u,time});
        }

        long dist[] = new long[n];
        long ways[] = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);

        dist[0]=0;
        ways[0]=1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0],b[0]));
        pq.add(new long[]{0,0});
        int MOD = 1_000_000_007;

        while(!pq.isEmpty()){
            long [] current = pq.poll();
            long currDist = current[0];
            int node = (int) current[1];

            if(currDist > dist[node]) continue;

            for(long[] neighbor : graph.get(node)){
                int nextNode = (int) neighbor[0];
                long time = neighbor[1];
                long newDist = currDist + time;

                if(newDist < dist[nextNode]){
                    dist[nextNode] = newDist;
                    ways[nextNode] = ways[node];
                    pq.add(new long[]{newDist, nextNode});
                }
                else if(newDist == dist[nextNode]){
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }
        return (int)(ways[n-1]%MOD);
    }
}