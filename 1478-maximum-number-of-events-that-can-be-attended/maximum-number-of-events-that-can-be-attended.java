class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> Integer.compare(a[0],b[0]));

        int day =0;
        int idx = 0;
        int n=events.length;
        int res =0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(!pq.isEmpty() || idx < n){
            if(pq.isEmpty()){
                day = events[idx][0];
            }
            while(idx < n && events[idx][0] <= day){
                pq.add(events[idx][1]);
                idx++;
            
            }
            pq.poll();
            res++;
            day++;

            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }
        }
        return res;
    }
}