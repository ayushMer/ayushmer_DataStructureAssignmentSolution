package main;


class Node
{
    int val;
    Node left, right;
    
    Node(int item)
    {
        val = item;
        left = right = null;
    }
}

public class driver {

	    public static Node node;
	    static Node prevNode = null;
	    static Node headNode = null;
	   
	    static void bstToSkewed(Node root,int order)
	    {
	       
	        // Base Case
	        if(root == null)
	        {
	            return;
	        }
	       
	        // Condition to check the order
	        // in which the skewed tree to
	        // maintained
	        if(order > 0)
	        {
	        	bstToSkewed(root.right, order);
	        }
	        else
	        {
	        	bstToSkewed(root.left, order);
	        }
	        Node rightNode = root.right;
	        Node leftNode = root.left;
	       
	        if(headNode == null)
	        {
	            headNode = root;
	            root.left = null;
	            prevNode = root;
	        }
	        else
	        {
	            prevNode.right = root;
	            root.left = null;
	            prevNode = root;
	        }
	       
	        if (order > 0)
	        {
	        	bstToSkewed(leftNode, order);
	        }
	        else
	        {
	        	bstToSkewed(rightNode, order);
	        }
	    }
	   
	    // Function to traverse the right
	    // skewed tree using recursion
	    static void traverseRightSkewed(Node root)
	    {
	        if(root == null)
	        {
	            return;
	        }
	        System.out.print(root.val + " ");
	        traverseRightSkewed(root.right);       
	    }
	   
	    // Driver Code
	    public static void main (String[] args)
	    {
	        driver tree = new driver();
	        tree.node = new Node(10);
	        tree.node.left = new Node(7);
	        tree.node.left.left = new Node(5);
	        tree.node.left.right = new Node(8);
	        
	        tree.node.right = new Node(19);
	        tree.node.right.left = new Node(12);
	        tree.node.right.right = new Node(20);
	        
	        int order = 0;
	        bstToSkewed(node, order);
	        traverseRightSkewed(headNode);
	    }
	
}
