/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list);
        TreeNode result=solve(0,list.size()-1,list);
        return result;
    }
    public void inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public TreeNode solve(int left,int right,ArrayList<Integer> list){
        if(left>right) return null;
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(list.get(mid));
        root.left=solve(left,mid-1,list);
        root.right=solve(mid+1,right,list);
    return root;
    }
}