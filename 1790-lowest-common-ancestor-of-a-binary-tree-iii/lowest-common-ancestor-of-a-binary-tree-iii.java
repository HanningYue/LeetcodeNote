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
        Node nodeOne = p, nodeTwo = q;
        while (nodeOne != nodeTwo) {
            if (nodeOne == null) {
                nodeOne = q;
            } else {
                nodeOne = nodeOne.parent;
            }
            if (nodeTwo == null) {
                nodeTwo = p;
            } else {
                nodeTwo = nodeTwo.parent;
            }
        }
        return nodeOne;
    }
}