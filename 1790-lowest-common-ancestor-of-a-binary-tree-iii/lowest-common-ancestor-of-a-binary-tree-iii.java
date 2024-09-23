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
        Node a = p, b = q;
        while (a != b) {
            if (a == null) {
                a = q;
                continue;
            }
            if (b == null) {
                b = p;
                continue;
            }
            a = a.parent;
            b = b.parent;
        }
        return a;
    }
}