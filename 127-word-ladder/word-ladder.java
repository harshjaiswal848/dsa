class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int level = 1;

        while(!q.isEmpty()){ 
            for(int size = q.size();size > 0; size--){
                String word = q.poll();
                char [] chars  =word.toCharArray();

                for(int j=0;j<chars.length;j++){
                    char original = chars[j];

                    for(char c='a'; c<='z';c++){
                        chars[j] = c;
                        String newWord = new String(chars);
                        if(newWord.equals(endWord)){
                            return level+1;

                        }
                        if(set.remove(newWord)){
                            q.add(newWord);
                        }
                    }
                    chars[j] =original;

                }
            }
            level++;
        }
        return 0;
    }
}