// BinaryTree by Yuanye Ma
import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData()
    {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes)
    {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val)
    {
        // Calls recursive function
        return search(root, val);
    }

    public boolean search (BSTNode n, int target)
    {
        // Checks to see if the node is null
        if (n == null)
        {
            return false;
        }
        // Checks to see if target is the node
        if (target == n.getVal())
        {
            return true;
        }
        // If not then checks to see if it is greater than the node
        if (target > n.getVal())
        {
            // Returns the value greater than the node
            return search(n.getRight(), target);
        }
        return search(n.getLeft(),target);
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder()
    {
        // Creates an ArrayList of nodes
        ArrayList<BSTNode> nodes = new ArrayList<>();
        getInorder(root, nodes);
        return nodes;
    }

    public void getInorder(BSTNode n, ArrayList<BSTNode> nodes)
    {
        // Repeats until the node is null
        if (n!= null)
        {
            // Visits each node from left to right in order and adds it to the ArrayList
            getInorder(n.getLeft(), nodes);
            nodes.add(n);
            getInorder(n.getRight(), nodes);
        }
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder()
    {
        // Same logic as getInOrder()
        ArrayList<BSTNode> nodes = new ArrayList<>();
        getPreorder(root, nodes);
        return nodes;
    }

    public void getPreorder(BSTNode n, ArrayList<BSTNode> nodes)
    {
        // Same recursive logic but this method traverses each node from left to right
        if (n != null)
        {
            nodes.add(n);
            getPreorder(n.getLeft(), nodes);
            getPreorder(n.getRight(), nodes);
        }

    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder()
    {
        // Same logic as previous two methods as it calls another recursive method
        ArrayList<BSTNode> nodes = new ArrayList<>();
        getPostorder(root, nodes);
        return nodes;
    }

    public void getPostorder(BSTNode n, ArrayList<BSTNode> nodes)
    {
        // Similar to previous methods but this order is left to right to node
        if (n!= null)
        {
            getInorder(n.getLeft(), nodes);
            getInorder(n.getRight(), nodes);
            nodes.add(n);
        }
    }
    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val)
    {
        // Calls a recursive method
        insert(val, root);
    }

    public void insert(int val, BSTNode n)
    {
        // Checks to see when the node is null
        if (n == null)
        {
            return;
        }
        // Checks to see if the val is to the right of the node
        if (val > n.getVal())
        {
            // If the right is null set the val to that node
            if (n.getRight() == null)
            {
                n.setRight(new BSTNode(val));
            }
            // Otherwise recurse with the right child of the node
            insert(val, n.getRight());
        }
        // Same logic as before but with the left side
        else if (val < n.getVal())
        {
            if (n.getLeft() == null)
            {
                n.setLeft(new BSTNode(val));
            }
            insert(val, n.getLeft());
        }
    }


    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST()
    {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args)
    {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
