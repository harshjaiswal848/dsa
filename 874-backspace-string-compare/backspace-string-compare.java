class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '#'){
                if(a.length() > 0){
                    a.deleteCharAt(a.length()-1);
                }
            }
            else{
                a.append(ch);
            }
        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(ch == '#'){
                if(b.length() > 0){
                    b.deleteCharAt(b.length()-1);
                }
            }
            else{
                b.append(ch);
            }
        }
        return a.toString().equals(b.toString());
    }
}