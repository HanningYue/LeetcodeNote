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
            if (a != null) {
                a = a.parent;
            } else {
                a = p;
            }
            if (b != null) {
                b = b.parent;
            } else {
                b = q;
            }
        }
        return a;
    }
}