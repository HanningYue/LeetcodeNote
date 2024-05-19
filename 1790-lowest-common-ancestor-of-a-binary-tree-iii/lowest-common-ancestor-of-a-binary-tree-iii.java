/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = q, b = p;

        while (a != b) {                
            if (a == null) {
                a = p;
            } else {
                a = a.parent;
            }

            if (b == null) {
                b = q;
            } else {
                b = b.parent;
            }
        }
        
        return a;
    }
}